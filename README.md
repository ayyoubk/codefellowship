# codefellowship

****This web application considers making a community of users and allow them to add posts and follow other users in order to see their posts and explore their own profile and posts in additin to other users on the application.****

### How To run

In your terminal:

- `git clone https://github.com/ayyoubk/codefellowship.git`
- Edit the the configuration of the database with yours to start properly
- `./gradlew bootRun`
- visit: `http://localhost:8080/`

### API

- GET requests
- `/` to show the home page
- `/signup` shows the signup page
- `/login` show the login page
- `/users/{id}` showed a specific user public profile using his id
- POST requests
- `/signup` Gets the user information and signs up the data to the database and authorize the user.
- `/post` allows the user to add a post to his profile.
- `/feed` show all post from following users 
- `/follow/{id}` let user to follow other user and add them to DB





