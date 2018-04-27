public class Pokedex extends AbstractPokemon implements PokemonInterface{
    public String pokemonInfo(Pokemon pikachu) {
        return ("Name: " + pikachu.getName() + " Heath: " + pikachu.getHealth() + " Type: " + pikachu.getType());
    }
}