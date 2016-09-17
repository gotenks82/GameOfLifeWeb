# GameOfLifeWeb
A simple Game of life simulation implementation, using a small FE app and a restful stateless json api

This app is developed using the Spring Boot framework.
Provides a restful stateless json api with a single endpoint: /evolve
* evolve takes as parameters the size of the universe (x,y) and the coordinates of live cells.
* returns the size of the evolved universe (the same size) and the coordinates of live cells after the evolution.

A small postman collection is included with test calls to evolve a vertical blinker into an horizontal blinker and vice-versa.

The app also provides a small frontend by using jquery.
By browsing to the root of the website (ex: http://localhost:8080/) the user will be asked the dimensions of the universe to evolve.
A grid of the selected size will appear, and the user can select which cells are going to be alive in the first generation.

A button under the grid will trigger evolutions and replace the grid with the new generations.

Basic Tests are provided for the model classes and for the controller.
