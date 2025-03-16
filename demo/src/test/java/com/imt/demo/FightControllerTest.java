package com.imt.demo;

import com.imt.demo.controller.FightController;
import com.imt.demo.model.CombatLog;
import com.imt.demo.model.Monster;
import com.imt.demo.service.CombatService;
import com.imt.demo.service.MonsterService;
import com.imt.demo.service.TokenValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FightControllerTest {

    @Mock
    private MonsterService monsterService;

    @Mock
    private CombatService combatService;

    @Mock
    private TokenValidationService tokenValidationService;

    @InjectMocks
    private FightController fightController;

    @Test
    void fightReturnLogs() throws Exception {
        UUID monster1Id = UUID.randomUUID();
        UUID monster2Id = UUID.randomUUID();
        Monster monster1 = mock(Monster.class);
        Monster monster2 = mock(Monster.class);
        CombatLog combatLog = new CombatLog(monster1Id, monster2Id, monster1Id, null);

        when(monsterService.getMonsterById(monster1Id)).thenReturn(monster1);
        when(monsterService.getMonsterById(monster2Id)).thenReturn(monster2);
        when(combatService.fight(monster1, monster2)).thenReturn(combatLog);
        doNothing().when(tokenValidationService).authenticate(anyString());

        ResponseEntity<CombatLog> response = fightController.fight("valid_token", monster1Id, monster2Id);

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertNotNull(response.getBody());
        assertEquals(combatLog, response.getBody());
    }

    @Test
    void fightReturnBadRequestWhenMonsterDoesNotExist() throws Exception {
        UUID monster1Id = UUID.randomUUID();
        UUID monster2Id = UUID.randomUUID();
        doNothing().when(tokenValidationService).authenticate(anyString());

        ResponseEntity<CombatLog> response = fightController.fight("valid_token", monster1Id, monster2Id);

        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
        assertNull(response.getBody());
    }
}
