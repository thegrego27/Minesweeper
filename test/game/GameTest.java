package game;

import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {
    @Test
    public void shouldCountFlagsOnStart() {
        // given
        Game game = new Game(5, 5, 0);

        // when
        int result = game.countFlagPoints();

        // then
        assertEquals(result, 0);
    }

    @Test
    public void shouldCountUnflaggedBomb() {
        // given
        Game game = new Game(5, 5, 0);
        Field flaggedBomb = game.getField(0, 0);
        Field unflaggedBomb = game.getField(0, 1);
        flaggedBomb.setBomb(true);
        unflaggedBomb.setBomb(true);
        flaggedBomb.setFlag(true);

        // when
        int result = game.countFlagPoints();

        // then
        assertEquals(result, 1);
    }

    @Test
    public void shouldCountFlaggedBombs() {
        // given
        Game game = new Game(5, 5, 0);
        Field flaggedBomb = game.getField(0, 0);
        Field flaggedField = game.getField(0, 2);
        flaggedBomb.setBomb(true);
        flaggedBomb.setFlag(true);
        flaggedField.setFlag(true);

        // when
        int result = game.countFlagPoints();

        // then
        assertEquals(result, 0);
    }
    //jezeli wszystkie pola sa odkryte, jezeli zadne pole nie jest odkryte, jezeli 1 pole jest odkryte

    @Test
    public void shouldCountUndiscoveredFieldsOnStart() {
        // given
        Game game = new Game(5, 5, 0);

        // when
        int result = game.countDiscoveredFields();

        // then
        assertEquals(result, 5 * 5);
    }

    @Test
    public void shouldCountDiscoveredField() {
        // given
        Game game = new Game(5, 5, 0);
        Field field = game.getField(0, 0);
        field.setDiscovered(true);

        // when
        int result = game.countDiscoveredFields();

        // then
        assertEquals(result, (5 * 5) - 1);
    }

    @Test
    public void shouldCountDiscoveredAndBombField() {
        // given
        Game game = new Game(5, 5, 0);
        Field discoveredField = game.getField(0, 0);
        Field bombField = game.getField(0, 1);
        discoveredField.setDiscovered(true);
        bombField.setBomb(true);

        // when
        int result = game.countDiscoveredFields() - 1;

        // then
        assertEquals(result, (5 * 5) - 2);
    }

    @Test
    public void shouldCountAllDiscoveredFields() {
        // given
        Game game = new Game(5, 5, 0);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Field field = game.getField(i, j);
                field.setDiscovered(true);
            }
        }

        // when
        int result = game.countDiscoveredFields();

        // then
        assertEquals(result, 0);
    }

}
