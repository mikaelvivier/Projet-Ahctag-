import { useState } from "react";

function CreatePlayerForm() {
    const [name, setName] = useState("");
    const [lvl, setLvl] = useState("");

    const handleSubmit = async (event) => {
        event.preventDefault();

        const playerData = { name, lvl };

        const response = await fetch("http://localhost:8082/player/save", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
                "Authorization": "Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJCYXB0aXN0ZSIsImlhdCI6MTc0MjE0NjY4OX0.a1JtMYCqdJ3Yuwjy_-36UZ3vDsPkvGNy2uyTFTGhtzk"
            },
            body: JSON.stringify(playerData),
        });

        if (response.ok) {
            alert("Joueur créé !");
        } else {
            alert("Erreur lors de la création.");
        }
    };

    return (
        <div>
            <h2>Créer un joueur</h2>
            <form onSubmit={handleSubmit}>
                <label>Nom :</label>
                <input type="text" value={name} onChange={(e) => setName(e.target.value)} required />
                <br/>
                <label>Niveau :</label>
                <input type="number" value={lvl} onChange={(e) => setLvl(e.target.value)} required />
                <br/>
                <button type="submit">Créer</button>
            </form>
        </div>
    );
}

export default CreatePlayerForm;