package com.backend.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name="CLIENT")
@AttributeOverrides({
    @AttributeOverride(name = "id", column = @Column(name = "ID_CLIENT")),
    @AttributeOverride(name = "nom", column = @Column(name = "NOM_CLIENT")),
    @AttributeOverride(name = "prenom", column = @Column(name = "PRENOM_CLIENT")),
    @AttributeOverride(name = "cin", column = @Column(name = "CIN_CLIENT")),
    @AttributeOverride(name = "adresse", column = @Column(name = "ADRESSE_CLIENT")),
    @AttributeOverride(name = "telephone", column = @Column(name = "TELEPHONE_CLIENT")),
    @AttributeOverride(name = "email", column = @Column(name = "EMAIL_CLIENT")),
    @AttributeOverride(name = "username", column = @Column(name = "USERNAME_CLIENT")),
    @AttributeOverride(name = "password", column = @Column(name = "PASSWORD_CLIENT")),
    @AttributeOverride(name = "role", column = @Column(name = "ROLE_CLIENT"))
})
@Inheritance(strategy = InheritanceType.JOINED)
public @Data class Client  extends Utilisateur{
	
	@Column(name="EST_OPERATEUR_CLIENT")
	String estOperateur;
	
	@JoinColumn(name="CREATION_AGENT_CLIENT")
	@ManyToOne
	Agent creationAgent;

	@JoinColumn(name="AGENCE_CLIENT")
	@ManyToOne
	Agence agence;
	
	@JsonIgnore
	@Column(name="COMPTES_CLIENT")
	@OneToMany(mappedBy="proprietaire",cascade=CascadeType.ALL)
	List<Compte> comptes;

	@JsonIgnore
	@OneToOne( cascade = CascadeType.ALL)
	RendezVous rendezVous;

}
