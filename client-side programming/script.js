//javascript objects used a basic database
const userData = {
    "Dheeraj": "1234",
    "Chirag": "5678"
};

document.getElementById("form").addEventListener("submit", (event) => {
    event.preventDefault(); // Prevent the default form submission

    // Retrieve form data using element id
    const username = document.getElementById("username").value;
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;
    const cars = document.getElementById("cars").value;
    const description = document.getElementById("description").value;
    const rating = document.getElementById("rating").value;

    // Hide the form
    const form = document.getElementById("form");
    form.style.display = "none";

    // Validate the form data first
    const validationResult = validate(username, password);

    if (validationResult.isValid) {

        const headerMessage = "Thank you for submitting your details!";
        const outputMessage = `
        <h4>Your submitted details:</h4>
        <p><strong>Username:</strong> ${username}</p>
        <p><strong>Email:</strong> ${email}</p>
        <p><strong>Favourite Car:</strong> ${cars}</p>
        <p><strong>Description:</strong> ${description}</p>
        <p><strong>Rating:</strong> ${rating}</p>
        `;

        setHeaderAndOutput(headerMessage, outputMessage);
    } else {
        setHeaderAndOutput(validationResult.headerMessage, validationResult.outputMessage);
    }
});


const validate = (username, password) => {
    // Check if user exists
    if (!username || !(username in userData)) {
        return {
            isValid: false,
            headerMessage: "Login Failed",
            outputMessage: `<h4>User does not exist</h4>`
        };
    }

    // Check if password is 4 digits long using regex
    if (!/^\d{4}$/.test(password)) {
        return {
            isValid: false,
            headerMessage: "Login Failed",
            outputMessage: `<h4>Password must be a 4-digit number</h4>`
        };
    }

    // Check if the password matches the stored value
    if (userData[username] !== password) {
        return {
            isValid: false,
            headerMessage: "Login Failed",
            outputMessage: `<h4>Incorrect username or password</h4>`
        };
    }

    // If all checks pass
    return { isValid: true };
};


const setHeaderAndOutput = (headerMessage, outputMessage) => {
    // Change the header
    const header = document.getElementById("header");
    header.innerText = headerMessage;

    // Display the output message
    const detailsDiv = document.getElementById("outputMessage");
    detailsDiv.style.display = 'block'; // to unhide the output div
    detailsDiv.innerHTML = outputMessage;
};
