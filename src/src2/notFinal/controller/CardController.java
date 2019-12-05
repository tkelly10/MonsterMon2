package notFinal.controller;

import hibernate.entity.Card;
import notFinal.service.CardService;
import notFinal.service.ColorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Controller
@RequestMapping("/card")
public class CardController {

   @Autowired
    private CardService cardService;

    @Autowired
    private ColorService colorService;

    public String deleteDonut(@RequestParam("cardId") int theId){
        cardService.deleteCard(theId);

        return "redirect:/card/list";
    }

    @GetMapping("/search")
    public String search(@RequestParam("cardId") String theSearchTerm, Model theModel){
        List<Card> list = cardService.getCardByName(theSearchTerm);

        theModel.addAttribute("cards", list);

        return "list-cards";
    }

    @GetMapping("/delete")
    public String deleteCard(@RequestParam("cardId") int theId){
        cardService.deleteCard(theId);

        return "redirect:/card/list";
    }

    @RequestMapping("/showUpdateCardForm")
    public String showUpdateCardForm(@RequestParam("cardID") int theId,
                                     Model theModel){

        Card theCard = cardService.getCard(theId);

        theModel.addAttribute("aCard", theCard);

        theModel.addAttribute("colors", colorService.getCardColors());

        return "add-card-form";
    }

    @RequestMapping("/list")
    public String listCards(Model theModel){
        List<Card> cardList = cardService.getCards();

        theModel.addAttribute("cards", cardList);

        return "list-cards";
    }

    @GetMapping("/showAddCardForm")
    public String showAddCardForm(Model theModel){
        Card newCard = new Card();

        theModel.addAttribute("aCard", newCard);

        theModel.addAttribute("cardColor", colorService.getCardColors());

        return "add-card-form";
    }

    @PostMapping("/save")
    public String saveCard(@ModelAttribute(name = "aCard") Card aCard, Model theModel
                           ){

        theModel.addAttribute("colors", colorService.getCardColors());

        cardService.saveCard(aCard);

        return "redirect:/card/list";

    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void handle(Exception e){e.printStackTrace();}
}
