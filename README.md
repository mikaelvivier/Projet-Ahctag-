# To start the project : 
> go to
  docker-compose directory

> hit those commands 
  cd docker-compose
  docker compose build
  docker compose up

start to run the app

To activate the front, remove (#) on front service in docker-compose.yaml
building the image is reaaaally long.. you can test the app on postman 

# --- step 1 : --- 
register at
localhost:8081/auth/register 

login at 
localhost:8081/auth/login
(save your Bearer Token, you'll need it later for every CRUD on the other APIs)

# --- step 2: ---
create monsters 
post localhost:8080/monster/save
{
    "type":"VENT",
    "hp":30,
    "atk":10,
    "def":10,
    "vit":10
}

level up a monster
localhost:8080/monster/levelup/{idMonster}


you can level up your monster with 
localhost:8080/monster/levelup/{monsterId}
(you can get the id in the database, for exemple with mongosh)

# --- step 3: ---
create players
post localhost:8082/player/save
{
    "name": "joueur1",
    "lvl": 1
}

# --- step 4: ---
generate monsters for a player
post localhost:8083/invocate/invocateMonstersForPlayer/{playerId}

# --- step 5: ---
Make a fight
post localhost:8084/fight/{idMonster1}/{idMonster2}

# --- Others ---

- unit tests are available on API fight and API authenticator
- Get methods are also available. For exemple on API Monster, you can Get all the monsters or filter with a Get monsters by Type.

