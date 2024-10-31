package school.sptech;

import school.sptech.especialistas.DesenvolvedorMobile;
import school.sptech.especialistas.DesenvolvedorWeb;

import java.util.ArrayList;
import java.util.List;

public class Consultoria extends DesenvolvedorWeb {
    private String nome;
    private Integer vagas;
    private List<Desenvolvedor> desenvolvedores;

    public Consultoria(String nome, Integer vagas) {
        this.nome = nome;
        this.vagas = vagas;
        this.desenvolvedores = new ArrayList<>();
    }

    public Consultoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getVagas() {
        return vagas;
    }

    public void setVagas(Integer vagas) {
        this.vagas = vagas;
    }
    public Boolean contratar(Desenvolvedor desenvolvedor){
        if (vagas > desenvolvedores.size()){
            desenvolvedores.add(desenvolvedor);
            return true;
        }return false;
    }
    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor){
        if (desenvolvedor.isFullstack()){
          contratar(desenvolvedor);
          return true;
        }
        return false;
    }
    public Double getTotalSalarios(){
        Double total = 0.0;
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores){
            total += desenvolvedorDaVez.calcularSalario();
        }return total;
    }
    public Integer qtdDesenvolvedoresMobile(){
        Integer cont = 0;
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores){
            if (desenvolvedorDaVez instanceof DesenvolvedorMobile){
                cont++;
        }
        }return cont;

    }

}
