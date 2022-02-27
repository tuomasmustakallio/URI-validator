# URI-validator

This is a coding task for Visma Solutions.

I didn't really know what a uri was but I made some research on it and decided to write the project using Java.
I used the [Java Class URI](https://docs.oracle.com/javase/7/docs/api/java/net/URI.html) for parsing and handling the URI which made the task easier than I imagined.

I understood that the task was to verify that a given uri was correct and extract the parameters that came with it.
I tried to minimize failures by adding try-catches and if-statements where I imagined there could be an error with wrong input
but given that the time limit was 2-3 hours I focused on the correct uri's and had to sacrifice some time thinking about the possible errors there could be.
The task ended up taking me about three hours with making unit tests for the validation method and fixing some clear errors that could come up with incorrect inputs.

For further improvement of the class I would polish returning the parameters and maybe I would even combine them to a single method you don't have to do it in the interface-side.
