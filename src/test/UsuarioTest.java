package test;

import org.junit.jupiter.api.Test;
import usuario.Usuario;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    // Test de las clases de equivalencia ////////////////////////////////////////////////////////////////////

    @Test
    public void CE_TC1_registroValido() {
        Usuario u = new Usuario(
                "Mario1",
                "Abc1",
                18,
                "user@test.com"
        );

        assertTrue(u.validarRegistro());
    }

    @Test
    public void CE_TC2_usuarioInvalido() {
        Usuario u = new Usuario(
                "abc",
                "Abc1",
                18,
                "user@test.com"
        );

        assertFalse(u.validarRegistro());
    }

    @Test
    public void CE_TC3_contrasenaSinMayuscula() {
        Usuario u = new Usuario(
                "Mario1",
                "abc123",
                18,
                "user@test.com"
        );

        assertFalse(u.validarRegistro());
    }

    @Test
    public void CE_TC4_correoSinArroba() {
        Usuario u = new Usuario(
                "Mario1",
                "Abc1",
                18,
                "usertest.com"
        );

        assertFalse(u.validarRegistro());
    }

    @Test
    public void CE_TC5_edadInvalida() {
        Usuario u = new Usuario(
                "Mario1",
                "Abc1",
                17,
                "user@test.com"
        );

        assertFalse(u.validarRegistro());
    }

    @Test
    public void CE_TC6_maximosValidos() {
        Usuario u = new Usuario(
                "abcdefghijklmno",
                "Abcd123",
                30,
                "a@b.com"
        );

        assertTrue(u.validarRegistro());
    }

    @Test
    public void CE_TC7_todosInvalidos() {
        Usuario u = new Usuario(
                null,
                "Abc#12",
                15,
                "user@com"
        );

        assertFalse(u.validarRegistro());
    }

    // Test de los valores limite ////////////////////////////////////////////////////////////////////


    @Test
    public void VL_TC1_usuarioMinimoValido() {
        Usuario u = new Usuario(
                "abcde",
                "Abc1",
                18,
                "a@b.c"
        );

        assertTrue(u.validarRegistro());
    }

    @Test
    public void VL_TC2_usuarioMenorMinimo() {
        Usuario u = new Usuario(
                "abcd",
                "Abc1",
                18,
                "a@b.c"
        );

        assertFalse(u.validarRegistro());
    }

    @Test
    public void VL_TC3_usuarioMaximoValido() {
        Usuario u = new Usuario(
                "abcdefghijklmno",
                "Abcd123",
                19,
                "a@b.c"
        );

        assertTrue(u.validarRegistro());
    }

    @Test
    public void VL_TC4_usuarioMayorMaximo() {
        Usuario u = new Usuario(
                "abcdefghijklmnop",
                "Abcd123",
                18,
                "a@b.c"
        );

        assertFalse(u.validarRegistro());
    }

    @Test
    public void VL_TC5_contrasenaMenorMinima() {
        Usuario u = new Usuario(
                "abcde",
                "A1b",
                18,
                "a@b.c"
        );

        assertFalse(u.validarRegistro());
    }

    @Test
    public void VL_TC6_contrasenaMayorMaxima() {
        Usuario u = new Usuario(
                "abcde",
                "Abcdef12",
                17,
                "ab.c"
        );

        assertFalse(u.validarRegistro());
    }

    // ==============================
    // TESTS UNITARIOS INDIVIDUALES
    // ==============================

    @Test
    public void validarUsuario_null() {
        Usuario u = new Usuario(
                null,
                "Abc1",
                18,
                "user@test.com"
        );

        assertFalse(u.validarUsuario());
    }

    @Test
    public void validarContrasena_caracterEspecial() {
        Usuario u = new Usuario(
                "Mario1",
                "Abc#12",
                18,
                "user@test.com"
        );

        assertFalse(u.validarContrasena());
    }

    @Test
    public void validarCorreo_null() {
        Usuario u = new Usuario(
                "Mario1",
                "Abc1",
                18,
                null
        );

        assertFalse(u.validarCorreo());
    }

    @Test
    public void validarEdad_18() {
        Usuario u = new Usuario(
                "Mario1",
                "Abc1",
                18,
                "user@test.com"
        );

        assertTrue(u.validarEdad());
    }

    @Test
    public void validarEdad_17() {
        Usuario u = new Usuario(
                "Mario1",
                "Abc1",
                17,
                "user@test.com"
        );

        assertFalse(u.validarEdad());
    }
}