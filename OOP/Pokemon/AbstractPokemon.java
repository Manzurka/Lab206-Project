public abstract class AbstractPokemon implements PokemonInterface {
    public Pokemon createPokemon(String name, int health, String type) {
        Pokemon pikachu = new Pokemon(name, health, type);
        return pikachu;
    }
    public void attackPokemon(Pokemon pikachu) {
        pikachu.setHealth(pikachu.getHealth()-10);
    }
}