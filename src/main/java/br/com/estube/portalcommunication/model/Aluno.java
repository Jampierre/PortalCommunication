/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estube.portalcommunication.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 *
 * @author Jampierre
 */
@Entity
@Table(name = "aluno")
public class Aluno extends ModelBase{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    
    @Column(name = "bairro")
    private String bairro;
    
    @Column(name = "cep")
    private String cep;
    
    @Column(name = "cidade")
    private String cidade;
    
    @Column(name = "complemento")
    private String complemento;
    
    @Column(name = "cpf")
    private String cpf;
    
    @Column(name = "email")
    private String email;
    
    @Column(name = "endereco")
    private String endereco;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "numero")
    private String numero;
    
    @Column(name = "uf")
    private String uf;
    
    @Column(name = "idusuario")
    private Long idUsuario;
    
    @Column(name = "telefone")
    private String telefone;
    
    @Column(name = "url")
    private String url;
    
    @Column(name = "grauescolaridade")
    private String grauEscolaridade;
    
    @Column(name = "instituicaoensino")
    private String instituicaoensino;
    
    @Column(name = "objetivo")
    private Long objetivo;
    
    @Column(name = "administracao")
    private Long administracao;
    
    @Column(name = "informaticabasica")
    private Long informaticaBasica;
    
    @Column(name = "educacao")
    private Long educacao;
    
    @Column(name = "meioambiente")
    private Long meioAmbiente;
    
    @Column(name = "concursopublico")
    private Long concursoPublico;
    
    @Column(name = "idiomas")
    private Long idiomas;
    
    @Column(name = "nutricao")
    private Long nutricao;
    
    @Column(name = "contabilidade")
    private Long contabilidade;
    
    @Column(name = "gestao")
    private Long gestao;
    
    @Column(name = "gestaolideranca")
    private Long gestaoLideranca;
    
    @Column(name = "marketingvendas")
    private Long marketingVendas;
    
    @Column(name = "recursoshumanos")
    private Long recursosHumanos;
    
    @Column(name = "economiafinancas")
    private Long economiaFinanceiras;
    
    @Column(name = "gestaoimobiliaria")
    private Long gestaoImobiliaria;
    
    @Column(name = "logistica")
    private Long logistica;
    
    @Column(name = "tecnologiainformacao")
    private Long tecnologiaInformacao;
    
    @Column(name = "desenvolvimentojogos")
    private Long desenvolvimentoJogos;
    
    @Column(name = "educacaopedagogia")
    private Long educacaoPedagogia;
    
    @Column(name = "cienciassociais")
    private Long cienciasSociais;
    
    @Column(name = "direitoexameordem")
    private Long direitoExameOrdem;
    
    @Column(name = "concursoPetrobras")
    private Long concursoPetrobras;
    
    @Column(name = "engenharias")
    private Long engenharias;
    
    @Column(name = "arquitetura")
    private Long arquitetura;
    
    @Column(name = "veterinaria")
    private Long veterinaria;
    
    @Column(name = "medicina")
    private Long medicina;
    
    @Column(name = "enfermagem")
    private Long enfermagem;
    
    @Column(name = "fisioterapia")
    private Long fisioterapia;
    
    @Column(name = "educacaofisicaesportes")
    private Long educacaoFisicaEsportes;
    
    @Column(name = "psicologia")
    private Long psicologia;
    
    @Column(name = "fotografia")
    private Long fotografia;
    
    @Column(name = "turismoeventos")
    private Long turismoEventos;
    
    @Column(name = "estetica")
    private Long estetica;
    
    @Column(name = "culinaria")
    private Long culinaria;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getInstituicaoensino() {
        return instituicaoensino;
    }

    public void setInstituicaoensino(String instituicaoensino) {
        this.instituicaoensino = instituicaoensino;
    }

    public Long getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Long objetivo) {
        this.objetivo = objetivo;
    }

    public Long getAdministracao() {
        return administracao;
    }

    public void setAdministracao(Long administracao) {
        this.administracao = administracao;
    }

    public Long getInformaticaBasica() {
        return informaticaBasica;
    }

    public void setInformaticaBasica(Long informaticaBasica) {
        this.informaticaBasica = informaticaBasica;
    }

    public Long getEducacao() {
        return educacao;
    }

    public void setEducacao(Long educacao) {
        this.educacao = educacao;
    }

    public Long getMeioAmbiente() {
        return meioAmbiente;
    }

    public void setMeioAmbiente(Long meioAmbiente) {
        this.meioAmbiente = meioAmbiente;
    }

    public Long getConcursoPublico() {
        return concursoPublico;
    }

    public void setConcursoPublico(Long concursoPublico) {
        this.concursoPublico = concursoPublico;
    }

    public Long getIdiomas() {
        return idiomas;
    }

    public void setIdiomas(Long idiomas) {
        this.idiomas = idiomas;
    }

    public Long getNutricao() {
        return nutricao;
    }

    public void setNutricao(Long nutricao) {
        this.nutricao = nutricao;
    }

    public Long getContabilidade() {
        return contabilidade;
    }

    public void setContabilidade(Long contabilidade) {
        this.contabilidade = contabilidade;
    }

    public Long getGestao() {
        return gestao;
    }

    public void setGestao(Long gestao) {
        this.gestao = gestao;
    }

    public Long getGestaoLideranca() {
        return gestaoLideranca;
    }

    public void setGestaoLideranca(Long gestaoLideranca) {
        this.gestaoLideranca = gestaoLideranca;
    }

    public Long getMarketingVendas() {
        return marketingVendas;
    }

    public void setMarketingVendas(Long marketingVendas) {
        this.marketingVendas = marketingVendas;
    }

    public Long getRecursosHumanos() {
        return recursosHumanos;
    }

    public void setRecursosHumanos(Long recursosHumanos) {
        this.recursosHumanos = recursosHumanos;
    }

    public Long getGestaoImobiliaria() {
        return gestaoImobiliaria;
    }

    public void setGestaoImobiliaria(Long gestaoImobiliaria) {
        this.gestaoImobiliaria = gestaoImobiliaria;
    }

    public Long getLogistica() {
        return logistica;
    }

    public void setLogistica(Long logistica) {
        this.logistica = logistica;
    }

    public Long getTecnologiaInformacao() {
        return tecnologiaInformacao;
    }

    public void setTecnologiaInformacao(Long tecnologiaInformacao) {
        this.tecnologiaInformacao = tecnologiaInformacao;
    }

    public Long getDesenvolvimentoJogos() {
        return desenvolvimentoJogos;
    }

    public void setDesenvolvimentoJogos(Long desenvolvimentoJogos) {
        this.desenvolvimentoJogos = desenvolvimentoJogos;
    }

    public Long getEducacaoPedagogia() {
        return educacaoPedagogia;
    }

    public void setEducacaoPedagogia(Long educacaoPedagogia) {
        this.educacaoPedagogia = educacaoPedagogia;
    }

    public Long getCienciasSociais() {
        return cienciasSociais;
    }

    public void setCienciasSociais(Long cienciasSociais) {
        this.cienciasSociais = cienciasSociais;
    }

    public Long getDireitoExameOrdem() {
        return direitoExameOrdem;
    }

    public void setDireitoExameOrdem(Long direitoExameOrdem) {
        this.direitoExameOrdem = direitoExameOrdem;
    }

    public Long getConcursoPetrobras() {
        return concursoPetrobras;
    }

    public void setConcursoPetrobras(Long concursoPetrobras) {
        this.concursoPetrobras = concursoPetrobras;
    }

    public Long getEngenharias() {
        return engenharias;
    }

    public void setEngenharias(Long engenharias) {
        this.engenharias = engenharias;
    }

    public Long getArquitetura() {
        return arquitetura;
    }

    public void setArquitetura(Long arquitetura) {
        this.arquitetura = arquitetura;
    }

    public Long getVeterinaria() {
        return veterinaria;
    }

    public void setVeterinaria(Long veterinaria) {
        this.veterinaria = veterinaria;
    }

    public Long getMedicina() {
        return medicina;
    }

    public void setMedicina(Long medicina) {
        this.medicina = medicina;
    }

    public Long getEnfermagem() {
        return enfermagem;
    }

    public void setEnfermagem(Long enfermagem) {
        this.enfermagem = enfermagem;
    }

    public Long getFisioterapia() {
        return fisioterapia;
    }

    public void setFisioterapia(Long fisioterapia) {
        this.fisioterapia = fisioterapia;
    }

    public Long getEducacaoFisicaEsportes() {
        return educacaoFisicaEsportes;
    }

    public void setEducacaoFisicaEsportes(Long educacaoFisicaEsportes) {
        this.educacaoFisicaEsportes = educacaoFisicaEsportes;
    }

    public Long getPsicologia() {
        return psicologia;
    }

    public void setPsicologia(Long psicologia) {
        this.psicologia = psicologia;
    }

    public Long getFotografia() {
        return fotografia;
    }

    public void setFotografia(Long fotografia) {
        this.fotografia = fotografia;
    }

    public Long getTurismoEventos() {
        return turismoEventos;
    }

    public void setTurismoEventos(Long turismoEventos) {
        this.turismoEventos = turismoEventos;
    }

    public Long getEstetica() {
        return estetica;
    }

    public void setEstetica(Long estetica) {
        this.estetica = estetica;
    }

    public Long getCulinaria() {
        return culinaria;
    }

    public void setCulinaria(Long culinaria) {
        this.culinaria = culinaria;
    }

    public String getGrauEscolaridade() {
        return grauEscolaridade;
    }

    public void setGrauEscolaridade(String grauEscolaridade) {
        this.grauEscolaridade = grauEscolaridade;
    }

    public Long getEconomiaFinanceiras() {
        return economiaFinanceiras;
    }

    public void setEconomiaFinanceiras(Long economiaFinanceiras) {
        this.economiaFinanceiras = economiaFinanceiras;
    }
}
