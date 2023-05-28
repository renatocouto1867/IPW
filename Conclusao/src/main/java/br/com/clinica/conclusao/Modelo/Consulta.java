package br.com.clinica.conclusao.Modelo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class Consulta {
    private int id_consulta;
    private String entrevista;
    private String exame_fisico;
    private String exames_complementares;
    private String resultados_exames;
    private String hipoteses_diagnosticas;
    private String diagnostico_definitivo;
    private String tratamento_efetuado;
    private LocalDateTime data_hora;
    private int id_paciente;
    private int id_medico;

    public Consulta() {

    }

    public Consulta(String entrevista, String exame_fisico, String exames_complementares, String resultados_exames, String hipoteses_diagnosticas, String diagnostico_definitivo, String tratamento_efetuado, LocalDateTime data_hora, int id_paciente, int id_medico) {
        this.entrevista = entrevista;
        this.exame_fisico = exame_fisico;
        this.exames_complementares = exames_complementares;
        this.resultados_exames = resultados_exames;
        this.hipoteses_diagnosticas = hipoteses_diagnosticas;
        this.diagnostico_definitivo = diagnostico_definitivo;
        this.tratamento_efetuado = tratamento_efetuado;
        this.data_hora = data_hora;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
    }

    public Consulta(int id_consulta, String entrevista, String exame_fisico, String exames_complementares, String resultados_exames, String hipoteses_diagnosticas, String diagnostico_definitivo, String tratamento_efetuado, LocalDateTime data_hora, int id_paciente, int id_medico) {
        this.id_consulta = id_consulta;
        this.entrevista = entrevista;
        this.exame_fisico = exame_fisico;
        this.exames_complementares = exames_complementares;
        this.resultados_exames = resultados_exames;
        this.hipoteses_diagnosticas = hipoteses_diagnosticas;
        this.diagnostico_definitivo = diagnostico_definitivo;
        this.tratamento_efetuado = tratamento_efetuado;
        this.data_hora = data_hora;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
    }

    public int getId_consulta() {
        return id_consulta;
    }

    public void setId_consulta(int id_consulta) {
        this.id_consulta = id_consulta;
    }

    public String getEntrevista() {
        return entrevista;
    }

    public void setEntrevista(String entrevista) {
        this.entrevista = entrevista;
    }

    public String getExame_fisico() {
        return exame_fisico;
    }

    public void setExame_fisico(String exame_fisico) {
        this.exame_fisico = exame_fisico;
    }

    public String getExames_complementares() {
        return exames_complementares;
    }

    public void setExames_complementares(String exames_complementares) {
        this.exames_complementares = exames_complementares;
    }

    public String getResultados_exames() {
        return resultados_exames;
    }

    public void setResultados_exames(String resultados_exames) {
        this.resultados_exames = resultados_exames;
    }

    public String getHipoteses_diagnosticas() {
        return hipoteses_diagnosticas;
    }

    public void setHipoteses_diagnosticas(String hipoteses_diagnosticas) {
        this.hipoteses_diagnosticas = hipoteses_diagnosticas;
    }

    public String getDiagnostico_definitivo() {
        return diagnostico_definitivo;
    }

    public void setDiagnostico_definitivo(String diagnostico_definitivo) {
        this.diagnostico_definitivo = diagnostico_definitivo;
    }

    public String getTratamento_efetuado() {
        return tratamento_efetuado;
    }

    public void setTratamento_efetuado(String tratamento_efetuado) {
        this.tratamento_efetuado = tratamento_efetuado;
    }

    public LocalDateTime getData_hora() {
        return data_hora;
    }

    public void setData_hora(LocalDateTime data_hora) {
        this.data_hora = data_hora;
    }

    public int getId_paciente() {
        return id_paciente;
    }

    public void setId_paciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public int getId_medico() {
        return id_medico;
    }

    public void setId_medico(int id_medico) {
        this.id_medico = id_medico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Consulta consulta = (Consulta) o;
        return id_consulta == consulta.id_consulta;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_consulta);
    }

    @Override
    public String toString() {
        return "Consulta{" +
                "id_consulta=" + id_consulta +
                ", entrevista='" + entrevista + '\'' +
                ", exame_fisico='" + exame_fisico + '\'' +
                ", exames_complementares='" + exames_complementares + '\'' +
                ", resultados_exames='" + resultados_exames + '\'' +
                ", hipoteses_diagnosticas='" + hipoteses_diagnosticas + '\'' +
                ", diagnostico_definitivo='" + diagnostico_definitivo + '\'' +
                ", tratamento_efetuado='" + tratamento_efetuado + '\'' +
                ", data_hora=" + data_hora +
                ", id_paciente=" + id_paciente +
                ", id_medico=" + id_medico +
                '}';
    }
}
