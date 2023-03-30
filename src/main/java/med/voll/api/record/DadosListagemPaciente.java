package med.voll.api.record;

import med.voll.api.modelo.Paciente;

public record DadosListagemPaciente(Long id,String nome, String cpf) {
    public DadosListagemPaciente(Paciente paciente) {
        this(paciente.getId(),paciente.getNome(),paciente.getCpf());
    }

}
