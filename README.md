To start the project : 
> go to
  docker-compose directory

> hit those commands 
  cd docker-compose
  docker compose build
  docker compose up

start to run the app

# To activate the front, remove (#) on front service in docker-compose.yaml
# building the image is reaaaally long.. you can test the app on postman 

--- step 1 : --- 
register at
localhost:8081/auth/register 

login at 
localhost:8081/auth/login
(save your Bearer Token, you'll need it later)

--- step 2: ---
create monsters 
localhost:8080/monster/save
{
    "type":"VENT",
    "hp":30,
    "atk":10,
    "def":10,
    "vit":10
}

you can level up your monster with 
localhost:8080/monster/levelup/{monsterId}
(you can get the id in the database, for exemple with mongosh)

--- step 3: ---
create players
localhost:8082/player/save
{
    "name": "joueur1",
    "lvl": 1
}

step 4

