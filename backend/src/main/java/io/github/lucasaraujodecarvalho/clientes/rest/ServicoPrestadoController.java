package io.github.lucasaraujodecarvalho.clientes.rest;

import io.github.lucasaraujodecarvalho.clientes.model.entity.Cliente;
import io.github.lucasaraujodecarvalho.clientes.model.entity.ServicoPrestado;
import io.github.lucasaraujodecarvalho.clientes.model.repository.ClienteRepository;
import io.github.lucasaraujodecarvalho.clientes.model.repository.ServicoPrestadoRepository;
import io.github.lucasaraujodecarvalho.clientes.rest.dto.ServicoPrestadoDTO;
import io.github.lucasaraujodecarvalho.clientes.util.BigDecimalConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@RequestMapping("/api/servicos-prestados")
@RequiredArgsConstructor
public class ServicoPrestadoController {

    private final ClienteRepository clienteRepository;

    private final ServicoPrestadoRepository repository;

    private final BigDecimalConverter bigDecimalConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ServicoPrestado salvar(@RequestBody @Valid ServicoPrestadoDTO dto) {
        ServicoPrestado servicoPrestado = new ServicoPrestado();
        servicoPrestado.setDescricao(dto.getDescricao());
        LocalDate data = LocalDate.parse(dto.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        servicoPrestado.setData(data);

        Integer idCliente = dto.getIdCliente();
        Cliente cliente = clienteRepository.findById(idCliente)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cliente inexistente."));
        servicoPrestado.setCliente(cliente);

        servicoPrestado.setValor(bigDecimalConverter.converterStringParaBigDecimal(dto.getPreco()));
        return repository.save(servicoPrestado);
    }

    @GetMapping
    public List<ServicoPrestado> pesquisarServicosPrestados(
            @RequestParam(value = "nome", required = false, defaultValue = "") String nome,
            @RequestParam(value = "mes", required = false) Integer mes
    ) {
        return repository.findByNomeClienteAndMes("%" + nome + "%", mes);
    }

}
