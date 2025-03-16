package com.imt.demo;

import com.imt.demo.controller.InvocationController;
import com.imt.demo.model.Player;
import com.imt.demo.model.Monster;
import com.imt.demo.service.MonsterService;
import com.imt.demo.service.PlayerService;
import com.imt.demo.service.TokenValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import javax.naming.AuthenticationException;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.http.HttpStatus.*;

@ExtendWith(MockitoExtension.class)
class InvocationControllerTest {

    @Mock
    private MonsterService monsterService;

    @Mock
    private PlayerService playerService;

    @Mock
    private TokenValidationService tokenValidationService;

    @InjectMocks
    private InvocationController invocationController;

    @Test
    void shouldInvocateMonstersForPlayer() throws Exception {
        UUID playerId = UUID.randomUUID();
        Player player = new Player("player1", 1);
        Monster monster = mock(Monster.class);
        monster.setId(UUID.randomUUID());

        when(playerService.getPlayerById(playerId)).thenReturn(player);
        when(monsterService.invocateMonster()).thenReturn(monster);
        doNothing().when(tokenValidationService).authenticate(anyString());

        ResponseEntity<Player> response = invocationController.invocateMonstersforPlayer("validToken", playerId);

        assertEquals(OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(3, response.getBody().getMonsters().size());
    }

    @Test
    void shouldReturnUnauthorizedWhenPlayerNotFound() {
        UUID playerId = UUID.randomUUID();
        when(playerService.getPlayerById(playerId)).thenReturn(null);

        ResponseEntity<Player> response = invocationController.invocateMonstersforPlayer("validToken", playerId);

        assertEquals(UNAUTHORIZED, response.getStatusCode());
        assertNull(response.getBody());
    }
}
