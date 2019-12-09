package upmc.pcg.game;

import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);

    private String Choice = "1";

    private Deck packUser;

    private int CardUniqueId = 1;

    private Player player;

    private int Id;

    private String[] PokemonLevel = { "basic", "stage1", "stage2", "Mega" };

    private String[] Energy = { "Grass", "Fire", "Water", "Lightning", "Psychic", "Fighting", "Lightning", "Darkness", "Metal", "Fairy", "Dragon", "Colorless" };

    private String[] Trainer = { "Items", "Supporters", "Stadiums" };

    int CardId, HP;

    String energy, level, Cardname, trainer;
    
    public Deck getPackUser() {
        return packUser;
    }
    
    public void setPackUser(Deck packUser) {
        this.packUser = packUser;
    }

    public Menu(Player player) {
        this.player = player;
        packUser = player.getDeck();
    }

    public void Start() {
        System.out.println("Hello User \nWelcome to Pokedeck :\n");
        while (Integer.parseInt(Choice) != 0) {
            Menu();
            MenuChoice();
        }
    }

    public void Menu() {
        System.out.println("        Menu      \n");
        System.out.println("0 : Leave \n");
        System.out.println("1 : Display collection \n");
        System.out.println("2 : Add Card \n");
        System.out.println("3 : Delete Card \n");
        System.out.println("4 : Edit Card \n");
        System.out.println("5 : Search card \n");
        System.out.println("6 : Fetch deck \n");
        System.out.println("7 : Save deck \n");
    }

    public void MenuChoice() {
        Choice = sc.nextLine();
        if (Choice.equals("")) {
            Choice = "0";
            System.out.println("Any choice");
        }
        int number = Integer.parseInt(Choice);
        if (number == 0) {
            System.out.println("Have a nice day!\n");
        } else if (number == 1) {
            DisplayCollection(packUser);
            System.out.println("\n");
        } else if (number == 2) {
            AddCard(packUser);
            System.out.println("\n");
        } else if (number == 3) {
            DeleteCard(packUser);
            System.out.println("\n");
        } else if (number == 4) {
            EditCard(packUser);
            System.out.println("\n");
        } else if (number == 5) {
            SearchChoice(packUser);
            System.out.println("\n");
        } else if (number == 6) {
            FetchDeck(packUser);
        } else if (number == 7) {
            SaveDeck(packUser);
        } else {
            System.out.println("please enter right number");
        }
    }

    public void SaveDeckJson(Deck packUser) {
        Json j = new Json();
        System.out.println("What the name of file ?\n");
        Scanner sc = new Scanner(System.in);
        String Choice = sc.nextLine();
            j.saveDeck(packUser, Choice);
            System.out.println("Your deck is saved");
    }
    
    public void FetchDeckJson(Deck packUser) {
        Json j = new Json();
        System.out.println("What the name of file ?\n");
        Scanner sc = new Scanner(System.in);
        String Choice = sc.nextLine();
            this.packUser = j.fetchDeck(Choice);
            this.CardUniqueId = this.packUser.LastCardInDeck().getCardId() + 1;
            System.out.println("Your deck is retrieved");
    }

    public void SaveDeck(Deck packUser) {
        SerializationMain serialize = new SerializationMain();
        System.out.println("What the name of file ?\n");
        Scanner sc = new Scanner(System.in);
        String Choice = sc.nextLine();
            serialize.saveDeck(packUser, Choice);
            System.out.println("Your deck is saved");
    }

    public void FetchDeck(Deck packUser) {
        SerializationMain serialize = new SerializationMain();
        System.out.println("What the name of file ?\n");
        Scanner sc = new Scanner(System.in);
        String Choice = sc.nextLine();
            this.packUser = serialize.fetchDeck(Choice);
            this.CardUniqueId = this.packUser.LastCardInDeck().getCardId() + 1;
            System.out.println("Your deck is retrieved");
    }

    public int CardChoice() {
        System.out.println("What is the type of card you want to add : \n");
        System.out.println("1 : Pokemon \n 2 : Trainer \n 3 : Energy ");
        Scanner sc = new Scanner(System.in);
        Choice = sc.nextLine();
        int num = Integer.parseInt(Choice);
        return num;
    }

    public void SearchChoice(Deck packUser) {
        System.out.println("Do you want to seach by : \n");
        System.out.println(" 1 : Card Id \n 2 : Card Type \n 3 : Card Name");
        Scanner sc = new Scanner(System.in);
        Choice = sc.nextLine();
        int num = Integer.parseInt(Choice);
        SearcheBy(packUser, num);
    }

    public void AddCard(Deck packUser) {
        int menuAdd = CardChoice();
        Card c = CreatedCard(packUser, menuAdd);
        packUser.AddCard(c);
    }

    public void DeleteCard(Deck packUser) {
        DisplayCollection(packUser);
        System.out.println("Do you want to delete a card ?\nPlease enter the id of the card you want to delete");
        Scanner sc = new Scanner(System.in);
        Choice = sc.nextLine();
        int Id = Integer.parseInt(Choice);
        if (packUser.DeleteCard(Id)) {
            packUser.DeleteCard(Id);
            System.out.println("Your card is delete");
        } else {
            System.out.println("Please enter right number");
        }
    }

    public void EditCard(Deck packUser) {
        DisplayCollection(packUser);
        System.out.println("Do you want to modify a card ?\n");
        Card card = CardByNumber(packUser);
        if (card.getCardType().equals("Pokemon")) {
            EditPokemonCard(packUser, card);
        } else if (card.getCardType().equals("Trainer")) {
            EditTrainerCard(packUser, card);
        } else if (card.getCardType().equals("Energy")) {
            EditEnergyCard(packUser, card);
        }
    }

    public void DisplayCollection(Deck packUser) {
        if (packUser.DeckSize() == 0) {
            System.out.println(" Your pokedeck is empty");
        } else {
            packUser.DisplayDeck();
            System.out.println("\n");
        }
    }

    public Card CardByNumber(Deck packUser) {
        int CardId = 1;
        do {
            System.out.println("Please enter id card : ");
            Scanner sc = new Scanner(System.in);
            Choice = sc.nextLine();
            CardId = Integer.parseInt(Choice);
            if (!packUser.IdInDeck(CardId)) {
                System.out.println("This id card doesn't exit, please try again");
            }
        } while (!packUser.IdInDeck(CardId));
        return packUser.retrieveCard(CardId);
    }

    public void CardByType(Deck packUser) {
        String cardType = null;
        System.out.println("Card : \n");
        System.out.println(" 1 : Pokemon \n 2 : Trainer \n 3 : Energy ");
        Scanner sc = new Scanner(System.in);
        Choice = sc.nextLine();
        int searchedChoice = Integer.parseInt(Choice);
        if (searchedChoice == 1) {
            cardType = "Pokemon";
        } else if (searchedChoice == 2) {
            cardType = "Trainer";
        } else if (searchedChoice == 3) {
            cardType = "Energy";
        }
        packUser.CardByType(cardType);
    }

    public void CardByName(Deck packUser) {
        System.out.println("Please enter name of card : ");
        Scanner sc = new Scanner(System.in);
        String Choice = sc.nextLine();
        packUser.CardByName(Choice);
    }

    public void ListEnergy() {
        int i = 0;
        for (String en : Energy) {
            System.out.println(i + ". " + en);
            i++;
        }
    }

    public void ListPokemonLevel() {
        int i = 0;
        for (String Level : PokemonLevel) {
            System.out.println(i + ". " + Level);
            i++;
        }
    }

    public void ListTrainer() {
        int i = 0;
        for (String train : Trainer) {
            System.out.println(i + ". " + train);
            i++;
        }
    }

    public void PokemonParams(Deck packUser) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choice the pokemon type in this list :");
        ListEnergy();
        this.energy = Energy[Integer.parseInt(sc.nextLine())];
        System.out.println("Please enter Pokemon name :");
        this.Cardname = sc.nextLine();
        System.out.println("Please choice the pokemon level in this list :");
        ListPokemonLevel();
        level = PokemonLevel[Integer.parseInt(sc.nextLine())];
        System.out.println("Please enter Pokemon HP :");
        this.HP = Integer.parseInt(sc.nextLine());
    }

    public void TrainerParams(Deck packUser) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choice the trainer type in this list :");
        ListTrainer();
        Choice = sc.nextLine();
        Id = Integer.parseInt(Choice);
        this.trainer = Trainer[Id];
        System.out.println("Please enter Item name :");
        this.Cardname = sc.nextLine();
    }

    public void EnergyParams(Deck packUser) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please choice the energy type in this list :");
        ListEnergy();
        Choice = sc.nextLine();
        Id = Integer.parseInt(Choice);
        this.energy = Energy[Id];
    }

    public Card CreatePokemonCard(Deck packUser, int CardUniqueId) {
        PokemonParams(packUser);
        return new PokemonCard(CardUniqueId, this.energy, this.Cardname, this.HP, this.level);
    }

    public Card CreateTrainerCard(Deck packUser, int CardUniqueId) {
        TrainerParams(packUser);
        return new TrainerCard(CardUniqueId, this.trainer, this.Cardname);
    }

    public Card CreateEnergyCard(Deck packUser, int CardUniqueId) {
        EnergyParams(packUser);
        return new EnergyCard(CardUniqueId, this.energy);
    }

    public void EditPokemonCard(Deck packUser, Card card) {
        PokemonParams(packUser);
        PokemonCard pokemon = (PokemonCard) card;
        pokemon.edit(this.energy, this.Cardname, this.HP, this.level);
        System.out.println("Card saved !\n" + pokemon.cardDescrition() + "\n");
    }

    public void EditTrainerCard(Deck packUser, Card card) {
        TrainerParams(packUser);
        TrainerCard trainer = (TrainerCard) card;
        trainer.edit(this.trainer, this.Cardname);
        System.out.println("Card saved !\n" + trainer.cardDescrition() + "\n");
    }

    public void EditEnergyCard(Deck packUser, Card card) {
        EnergyParams(packUser);
        EnergyCard energy = (EnergyCard) card;
        energy.edit(this.energy);
        System.out.println("Card saved !\n" + energy.cardDescrition() + "\n");
    }

    public Card CreatedCard(Deck packUser, int id) {
        if (id == 1) {
            Card PokemonCard = CreatePokemonCard(packUser, CardUniqueId);
            CardUniqueId++;
            return PokemonCard;
        } else if (id == 2) {
            Card TrainerCard = CreateTrainerCard(packUser, CardUniqueId);
            CardUniqueId++;
            return TrainerCard;
        } else if (id == 3) {
            Card EnergyCard = CreateEnergyCard(packUser, CardUniqueId);
            CardUniqueId++;
            return EnergyCard;
        } else {
            System.out.println("Please enter a right number");
            return null;
        }
    }

    public void SearcheBy(Deck packUser, int id) {
        int CardId;
        String cardType = "Pokemon";
        if (id == 1) {
            System.out.println(CardByNumber(packUser).cardDescrition());
        } else if (id == 2) {
            CardByType(packUser);
        } else if (id == 3) {
            CardByName(packUser);
        } else {
            System.out.println("Nothing found");
        }
    }
}
