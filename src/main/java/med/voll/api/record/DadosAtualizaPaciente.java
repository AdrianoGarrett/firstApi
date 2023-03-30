package med.voll.api.record;

import jakarta.validation.Valid;

public record DadosAtualizaPaciente(Long id, String nome, String telefone, @Valid DadosEndereco endereco, boolean ativo) {

}
