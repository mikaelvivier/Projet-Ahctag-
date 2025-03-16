# Utilisation d'une image Node.js
FROM node:18-alpine

# Définir le répertoire de travail
WORKDIR /app

# Copier package.json et installer les dépendances
COPY package.json package-lock.json ./
RUN npm install

COPY . .
# Exposer le port 3000
EXPOSE 3000

# Démarrer l'application React
CMD ["npm", "start"]