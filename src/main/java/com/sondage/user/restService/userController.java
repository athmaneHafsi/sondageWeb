package com.sondage.user.restService;
import com.sondage.DAO.DAO;
import com.sondage.DAO.DAOFactory;
import com.sondage.user.Utilisateur;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class userController {

    @GetMapping("/getUser")
    public Utilisateur getUser(@RequestParam(value = "id") int id) {
        DAO<Utilisateur> utilisateurDAO = DAOFactory.getUtilisateurDAO();
        return utilisateurDAO.find(id);
    }
    @PostMapping("/")
    public Utilisateur get(@RequestParam(value = "id") int id) {
        DAO<Utilisateur> utilisateurDAO = DAOFactory.getUtilisateurDAO();
        return utilisateurDAO.find(id);
    }
}
