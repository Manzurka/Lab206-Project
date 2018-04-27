public interface PokemonInterface {
    Pokemon createPokemon(String name, int health, String type);
    void attackPokemon(Pokemon pikachu);
    String pokemonInfo(Pokemon pikachu);
}