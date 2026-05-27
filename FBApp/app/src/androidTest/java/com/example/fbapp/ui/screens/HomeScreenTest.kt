package com.example.fbapp.ui.screens


import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Assert.assertTrue
import org.junit.Rule
import org.junit.Test

class HomeScreenTest {

    //No tengo android asi que no pude verificar si me sirvio de verdad
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun verificarTextosYDatosDelUsuario() {

        val correoPrueba = "estudiante@uca.edu.sv"


        composeTestRule.setContent {
            HomeScreen(
                userEmail = correoPrueba,
                onLogout = {}
            )
        }
        composeTestRule.onNodeWithText("Bienvenido").assertIsDisplayed()
        composeTestRule.onNodeWithText(correoPrueba).assertIsDisplayed()
        composeTestRule.onNodeWithText("Inicio sesion correctamente").assertIsDisplayed()
    }

    @Test
    fun verificarAccionBotonCerrarSesion() {
        var sePresionoCerrarSesion = false

        composeTestRule.setContent {
            HomeScreen(
                userEmail = "estudiante@uca.edu.sv",
                onLogout = {
                    sePresionoCerrarSesion = true
                }
            )
        }

        composeTestRule.onNodeWithText("Cerrar Sesion").performClick()
        assertTrue(sePresionoCerrarSesion)
    }
}