package med.voll.api.controller;

import com.electronwill.nightconfig.core.conversion.Path;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.record.DadosAtualizaPaciente;
import med.voll.api.record.DadosCadastroPaciente;
import med.voll.api.record.DadosListagemPaciente;
import med.voll.api.modelo.Paciente;
import med.voll.api.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados) {
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable pageable) {
        return repository.findAllByAtivoTrue(pageable).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizar(@RequestBody @Valid DadosAtualizaPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deleta(@PathVariable Long id){
        var paciente = repository.getReferenceById(id);
        paciente.inativar();
    }

}

