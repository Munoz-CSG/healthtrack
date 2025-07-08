package com.healthtrack;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    public void testActualizarPeso_ValorEsperado() {
        Usuario usuario = new Usuario("Jorge", 81.0);
        usuario.actualizarPeso(78.5);
        assertEquals(78.5, usuario.getPeso(), 0.01);
    }

    @Test
    public void actualizarPeso_valorCero_lanzaExcepcion() {
        Usuario usuario = new Usuario("Isabel", 50.0);
        assertThrows(IllegalArgumentException.class, () -> {
            usuario.actualizarPeso(0.0);
        });
    }

    @Test
    public void actualizarPeso_valorNegativo_lanzaExcepcion() {
        Usuario usuario = new Usuario("Monserrat", 65.9);
        assertThrows(IllegalArgumentException.class, () -> {
            usuario.actualizarPeso(-2.5);
        });
    }
    @Test
    public void testNombreUsuario_seMantieneCorrectoTrasActualizarPeso() {
        Usuario usuario = new Usuario("Sofía", 60.0);
        usuario.actualizarPeso(62.0);
        assertEquals("Sofía", usuario.getNombre(), "El nombre del usuario debe permanecer intacto después de actualizar el peso.");
    }
}