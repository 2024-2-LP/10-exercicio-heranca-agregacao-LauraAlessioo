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

    public Boolean contratar(Desenvolvedor desenvolvedor) {
        if (vagas > desenvolvedores.size()) {
            desenvolvedores.add(desenvolvedor);
            return true;
        }
        return false;
    }

    public Boolean contratarFullstack(DesenvolvedorWeb desenvolvedor) {
        if (desenvolvedor.isFullstack()) {
            contratar(desenvolvedor);
            return true;
        }
        return false;
    }

    public Double getTotalSalarios() {
        Double total = 0.0;
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            total += desenvolvedorDaVez.calcularSalario();
        }
        return total;
    }

    public Integer qtdDesenvolvedoresMobile() {
        Integer cont = 0;
        for (Desenvolvedor desenvolvedorDaVez : desenvolvedores) {
            if (desenvolvedorDaVez instanceof DesenvolvedorMobile) {
                cont++;
            }
        }
        return cont;
    }

    public List<Desenvolvedor> buscarPorSalarioMaiorIgualQue(Double salario) {
        List<Desenvolvedor> maiorSalario = new ArrayList<>();
        for (Desenvolvedor desenvolvedorSalMenor : desenvolvedores) {
            if (desenvolvedorSalMenor.calcularSalario() >= salario) {
                maiorSalario.add(desenvolvedorSalMenor);
            }
        }
        return maiorSalario;
    }

    public Desenvolvedor buscarMenorSalario() {
        if (desenvolvedores.isEmpty()) {
            return null;
        }
        Desenvolvedor menorSalarioDev = desenvolvedores.get(0);

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev.calcularSalario().compareTo(menorSalarioDev.calcularSalario()) < 0) {
                menorSalarioDev = dev;
            }
        }
        return menorSalarioDev;
    }
    public List<Desenvolvedor> buscarPorTecnologia(String tecnologia) {
        List<Desenvolvedor> devsComTecnologia = new ArrayList<>();

        for (Desenvolvedor dev : desenvolvedores) {
            if (dev instanceof DesenvolvedorWeb) {
                DesenvolvedorWeb devWeb = (DesenvolvedorWeb) dev;
                if (tecnologia.equalsIgnoreCase(devWeb.getFrontend()) || tecnologia.equalsIgnoreCase(devWeb.getBackend()) || tecnologia.equalsIgnoreCase(devWeb.getSgbd())) {
                    devsComTecnologia.add(devWeb);
                }
            } else if (dev instanceof DesenvolvedorMobile) {
                DesenvolvedorMobile devMobile = (DesenvolvedorMobile) dev;
                if (tecnologia.equalsIgnoreCase(devMobile.getPlataforma()) || tecnologia.equalsIgnoreCase(devMobile.getLinguagem())) {
                    devsComTecnologia.add(devMobile);
                }
            }
        }
        return devsComTecnologia;
    }
    public Double getTotalSalariosPorTecnologia(String tecnologia) {
        Double totalSalarios = 0.0;

        List<Desenvolvedor> devsComTecnologia = buscarPorTecnologia(tecnologia);

        for (Desenvolvedor dev : devsComTecnologia) {
            totalSalarios += dev.calcularSalario();
        }

        return totalSalarios;
    }

}
