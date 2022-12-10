package med.voll.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.voll.api.endereco.DadosEndereco;

// foi criado um record class para receber os dados cadastrais obrigatorios de forma separada (nome, email, crm...)
//criar um enum especialidade
//criado um classe record (o record jé cria metodos e construtores) para DadosEndereço
//classe record só declaramos os parametros que queremos receber ou enviar. è um padrão muito utilizado em apis rest.
//usando o bean validation em cada propriedade (não nulo, não vazio..)
public record DadosCadastroMedico(
        @NotBlank //campo não pode estar em branco nem nulo
        String nome,
        @NotBlank
        @Email // tem que conter email
        String email,
        @NotBlank
        String telefone,
        @NotBlank
        @Pattern(regexp = "\\d{4,6}") //limitando quantidade de caracteres
        String crm,
        @NotNull
        Especialidade especialidade,
        @NotNull
        @Valid // para DTO outros objetos DTO
        DadosEndereco endereco) {
}
