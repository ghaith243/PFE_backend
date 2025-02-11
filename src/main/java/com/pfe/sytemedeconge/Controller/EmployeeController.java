package com.pfe.sytemedeconge.Controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pfe.sytemedeconge.Service.JwtUtil;
import Model.Utilisateur;
import Repository.UtilisateurRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200") 
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private UtilisateurRepository utilisateurRepository;

    @Autowired
    private JwtUtil jwtUtil;

    // Endpoint pour récupérer les données personnelles d'un employé
    @GetMapping("/me")
    public ResponseEntity<?> getEmployeeData(@RequestHeader("Authorization") String token) {
        // Extraire l'email depuis le token
        String email = jwtUtil.extractEmail(token.substring(7)); // Enlève "Bearer " du token

        // Trouver l'utilisateur par email
        Utilisateur user = utilisateurRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Utilisateur introuvable"));

        // Retourne uniquement les données personnelles de l'utilisateur
        return ResponseEntity.ok(Map.of(
            "id", user.getId(),
            "nom", user.getNom(),
            "email", user.getEmail(),
            "role", user.getRole().getName(),
            "service", user.getService().getNom()
        ));
    }
}