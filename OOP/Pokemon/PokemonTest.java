public class PokemonTest {
    public static void main(String[] args) {
        Pokedex x = new Pokedex();
        Pokemon mew = x.createPokemon("Mew", 50, "Psychic");
        System.out.println(x.pokemonInfo(mew));
    }
}