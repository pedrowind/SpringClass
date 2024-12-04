const inputs = document.getElementsByClassName("inputNumber");

for (const inputNumber of inputs) {
    if (inputNumber.name === "idade") {
        inputNumber.addEventListener("keypress", function (e) {
            const typed = +e.key;
            if (isNaN(typed) || typed < 0) {
                e.preventDefault();
            }
        });

        inputNumber.addEventListener("blur", function () {
            if (inputNumber.value < 18 && inputNumber.value !== "") {
                inputNumber.value = 18;
            }
        });
        continue;
    }

    inputNumber.addEventListener("keypress", function (e) {
        const typed = +e.key;
        if (isNaN(typed) || typed < 0) {
            e.preventDefault();
        }
        if (inputNumber.value >= 100) {
            inputNumber.value = 100;
            e.preventDefault();
        }
    });

    inputNumber.addEventListener("blur", function () {
        if (inputNumber.value === "") {
            inputNumber.value = 50;
        } else if (inputNumber.value > 100) {
            inputNumber.value = 100;
        }
    });
}