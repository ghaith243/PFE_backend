package Model;









import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;

import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name = "utilisateur") // Facultatif mais recommandé


public class Utilisateur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_utulisateur;
    
    private String nom;
    private String email;
    private String motDePasse;
    private int enfantCount;
    
    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role; 
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private Service service;
    @OneToMany(mappedBy = "utilisateur", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonIgnore
    
    private List<Conge> listeConges;


	
    
    
    

	public Long getId() {
		return id_utulisateur;
	}

	public void setId(Long id) {
		this.id_utulisateur = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}


	public int getEnfantCount() {
		return enfantCount;
	}

	public void setEnfantCount(int enfantCount) {
		this.enfantCount = enfantCount;
	}

	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	public List<Conge> getConges() {
		return listeConges;
	}

	public void setConges(List<Conge> conges) {
		this.listeConges = conges;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public List<Conge> getListeConges() {
		return listeConges;
	}

	public void setListeConges(List<Conge> listeConges) {
		this.listeConges = listeConges;
	}
	
    
    
}
