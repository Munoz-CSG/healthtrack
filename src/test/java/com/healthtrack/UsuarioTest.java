package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {
    @Test
    public void testActualizarPeso_ValorEsperado() {
        Usuario usuario = new Usuario("Jorge", 81.0);
        usuario.actualizarPeso(78.5);
        // Este test debería fallar mientras el método tenga el bug -1kg
        assertEquals(78.5, usuario.getPeso(), 0.01);
    }
}