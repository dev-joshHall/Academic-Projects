window.onload = function() {
    var edit_idx;
    var delete_idx;

    function roll3d6() {
        return Math.floor(Math.random() * 6 + 1) + Math.floor(Math.random() * 6 + 1) + Math.floor(Math.random() * 6 + 1);
    }
    
    let submitButton = document.getElementById("submitButton");
    submitButton.onclick = function() {
        let newHand;
        if (document.getElementById("rightHanded").checked) {
            newHand = "yes";
        } else {
            newHand = "no";
        }
        let errorPresent = false;
        let newGender;
        let genders = document.getElementsByName("gender");
        if (genders[0].checked) {
            newGender = "male";
            document.getElementById("genderError").innerHTML = "&nbsp";
        } else if (genders[1].checked) {
            newGender = "female";
            document.getElementById("genderError").innerHTML = "&nbsp";
        } else {
            document.getElementById("genderError").innerHTML = "*no gender provided";
            errorPresent = true;
        }
        if (document.getElementById("raceVal").value == "none") {
            document.getElementById("raceError").innerHTML = "*no race provided";
            errorPresent = true;
        } else {
            document.getElementById("raceError").innerHTML = "&nbsp";
        }
        if (document.getElementById("classVal").value == "none") {
            document.getElementById("classError").innerHTML = "*no class provided";
            errorPresent = true;
        } else {
            document.getElementById("classError").innerHTML = "&nbsp";
        }
        if (document.getElementById("nameVal").value == "") {
            document.getElementById("nameError").innerHTML = "*no name provided";
            errorPresent = true;
        } else {
            document.getElementById("nameError").innerHTML = "&nbsp";
        }
        if (errorPresent) {
            return -1;
        }

        newPerson = {
            pName: document.getElementById("nameVal").value,
            stren: document.getElementById("strengthVal").innerHTML,
            dex: document.getElementById("dexVal").innerHTML,
            cons: document.getElementById("conVal").innerHTML,
            itel: document.getElementById("itelVal").innerHTML,
            wisdom: document.getElementById("wisdomVal").innerHTML,
            charisma: document.getElementById("charismaVal").innerHTML,
            race: document.getElementById("raceVal").value,
            class: document.getElementById("classVal").value,
            gender: newGender,
            rightHanded: newHand
        }
        characters.push(newPerson);
        document.getElementById("editArea").style.display = "none";
        document.getElementById("createArea").style.display = "none";
        document.getElementById("charTable").style.display = "table";
        popChars();
    }

    submit_button = document.getElementById("submit-Button");
    submit_button.onclick = function() {
        let newHand;
        if (document.getElementById("right-Handed").checked) {
            newHand = "yes";
        } else {
            newHand = "no";
        }
        let errorPresent = false;
        let newGender;
        let genders = document.getElementsByName("gender1");
        if (genders[0].checked) {
            newGender = "male";
            document.getElementById("gender-Error").innerHTML = "&nbsp";
        } else if (genders[1].checked) {
            newGender = "female";
            document.getElementById("gender-Error").innerHTML = "&nbsp";
        } else {
            document.getElementById("gender-Error").innerHTML = "*no gender provided";
            errorPresent = true;
        }
        if (document.getElementById("race-Val").value == "none") {
            document.getElementById("race-Error").innerHTML = "*no race provided";
            errorPresent = true;
        } else {
            document.getElementById("race-Error").innerHTML = "&nbsp";
        }
        if (document.getElementById("class-Val").value == "none") {
            document.getElementById("class-Error").innerHTML = "*no class provided";
            errorPresent = true;
        } else {
            document.getElementById("class-Error").innerHTML = "&nbsp";
        }
        if (document.getElementById("name-Val").value == "") {
            document.getElementById("name-Error").innerHTML = "*no name provided";
            errorPresent = true;
        } else {
            document.getElementById("name-Error").innerHTML = "&nbsp";
        }
        if (errorPresent) {
            return -1;
        }
        let newCharacter =  {
            pName: document.getElementById("name-Val").value,
            stren: document.getElementById("strength-Val").innerHTML,
            dex: document.getElementById("dex-Val").innerHTML,
            cons: document.getElementById("con-Val").innerHTML,
            itel: document.getElementById("itel-Val").innerHTML,
            wisdom: document.getElementById("wisdom-Val").innerHTML,
            charisma: document.getElementById("charisma-Val").innerHTML,
            race: document.getElementById("race-Val").value,
            class: document.getElementById("class-Val").value,
            gender: newGender,
            rightHanded: newHand
        }
        characters[edit_idx] = newCharacter;
        document.getElementById("editArea").style.display = "none";
        document.getElementById("createArea").style.display = "none";
        document.getElementById("charTable").style.display = "table";
        popChars();

    }
    
    let john = {
        pName: "John",
        stren: roll3d6(),
        dex: roll3d6(),
        cons: roll3d6(),
        itel: roll3d6(),
        wisdom: roll3d6(),
        charisma: roll3d6(),
        race: "human",
        class: "fighter",
        gender: "male",
        rightHanded: "yes"
    }
    
    let sara = {
        pName: "Sara",
        stren: roll3d6(),
        dex: roll3d6(),
        cons: roll3d6(),
        itel: roll3d6(),
        wisdom: roll3d6(),
        charisma: roll3d6(),
        race: "elf",
        class: "wizard",
        gender: "female",
        rightHanded: "yes"
    }
    
    let james = {
        pName: "James",
        stren: roll3d6(),
        dex: roll3d6(),
        cons: roll3d6(),
        itel: roll3d6(),
        wisdom: roll3d6(),
        charisma: roll3d6(),
        race: "dwarf",
        class: "thief",
        gender: "male",
        rightHanded: "yes"
    }
    
    let susan = {
        pName: "Susan",
        stren: roll3d6(),
        dex: roll3d6(),
        cons: roll3d6(),
        itel: roll3d6(),
        wisdom: roll3d6(),
        charisma: roll3d6(),
        race: "halfling",
        class: "cleric",
        gender: "female",
        rightHanded: "no"
    }
    
    let characters = [john, sara, james, susan];

    function onUpdateBtnClicked(playerName) {
        let selectedCharacter;
        // get the character to be edited
        for (let i = 0; i < characters.length; i++) {
            if (characters[i].pName == playerName) {
                selectedCharacter = characters[i];
                edit_idx = i; // keep track of edited character's index
            }
        }
        if (selectedCharacter == null) {
            console.log("No matching character found");
            return -1;
        }
        document.getElementById("name-Val").value = selectedCharacter.pName;
        document.getElementById("strength-Val").innerHTML = selectedCharacter.stren;
        document.getElementById("dex-Val").innerHTML = selectedCharacter.dex;
        document.getElementById("con-Val").innerHTML = selectedCharacter.cons;
        document.getElementById("itel-Val").innerHTML = selectedCharacter.itel;
        document.getElementById("wisdom-Val").innerHTML = selectedCharacter.wisdom;
        document.getElementById("charisma-Val").innerHTML = selectedCharacter.charisma;
        document.getElementById("race-Val").value = selectedCharacter.race;
        document.getElementById("class-Val").value = selectedCharacter.class;
        if (selectedCharacter.gender == "male") {
            document.getElementsByName("gender1")[0].checked = true;
        } else {
            document.getElementsByName("gender1")[1].checked = true;
        }
        if (selectedCharacter.rightHanded == "yes") {
            document.getElementById("right-Handed").checked = true;
        } else {
            document.getElementById("right-Handed").checked = false;
        }

        document.getElementById("editArea").style.display = "table";
        document.getElementById("createArea").style.display = "none";
        document.getElementById("charTable").style.display = "none";
    }

    function onDeleteBtnClicked(playerName) {
        let selectedCharacter;
        // get the character to be deleted
        for (let i = 0; i < characters.length; i++) {
            if (characters[i].pName == playerName) {
                selectedCharacter = characters[i];
                delete_idx = i; // keep track of character's index
            }
        }
        if (selectedCharacter == null) {
            console.log("No matching character found");
            return -1;
        }
        characters.splice(delete_idx, 1);
        
        document.getElementById("editArea").style.display = "none";
        document.getElementById("createArea").style.display = "none";
        document.getElementById("charTable").style.display = "table";
        popChars();
    }

    function popChars() {
        // clear current children
        let tbl = document.getElementById("tableB");
        while (tbl.firstChild) {
            tbl.removeChild(tbl.firstChild);
        }
        for (let i = 0; i < characters.length; i++) {
            let el = document.createElement("div");
            el.className = "tableR";
            let el1 = document.createElement("div");
            el1.className = "tableC";
            el1.innerHTML = characters[i].pName;
            let el2 = document.createElement("div");
            el2.className = "tableC";
            el2.innerHTML = characters[i].race;
            let el3 = document.createElement("div");
            el3.className = "tableC";
            el3.innerHTML = characters[i].class;
            let el4 = document.createElement("div");
            el4.className = "tableC";
            el4.innerHTML = characters[i].gender;
            let el5 = document.createElement("input");
            el5.type = "button";
            el5.className = "tableBtn";
            el5.value = "Edit";
            el5.id = "editBtn" + i;
            el5.onclick = function() {
                onUpdateBtnClicked(el1.innerHTML);
            }
            let el6 = document.createElement("input");
            el6.type = "button";
            el6.className = "tableBtn";
            el6.value = "Delete";
            el6.id = "deleteBtn" + i;
            el6.onclick = function() {
                onDeleteBtnClicked(el1.innerHTML);
            }
            el.appendChild(el1);
            el.appendChild(el2);
            el.appendChild(el3);
            el.appendChild(el4);
            el.appendChild(el5);
            el.appendChild(el6);
            document.getElementById("tableB").appendChild(el);
        }
    }
    
    // populate character table on page load
    popChars();

    let newButton = document.getElementById("newChar");
    newButton.onclick = function() {
        document.getElementById("strengthVal").innerHTML = roll3d6();
        document.getElementById("dexVal").innerHTML = roll3d6();
        document.getElementById("conVal").innerHTML = roll3d6();
        document.getElementById("itelVal").innerHTML = roll3d6();
        document.getElementById("wisdomVal").innerHTML = roll3d6();
        document.getElementById("charismaVal").innerHTML = roll3d6();
        
        document.getElementById("charTable").style.display = "none";
        document.getElementById("editArea").style.display = "none";
        document.getElementById("createArea").style.display = "table";
    }

    let rerollButton = document.getElementById("rerollButton");
    rerollButton.onclick = function() {
        document.getElementById("strengthVal").innerHTML = roll3d6();
        document.getElementById("dexVal").innerHTML = roll3d6();
        document.getElementById("conVal").innerHTML = roll3d6();
        document.getElementById("itelVal").innerHTML = roll3d6();
        document.getElementById("wisdomVal").innerHTML = roll3d6();
        document.getElementById("charismaVal").innerHTML = roll3d6();
    }

    let rerollBtn = document.getElementById("reroll-Button");
    rerollBtn.onclick = function() {
        document.getElementById("strength-Val").innerHTML = roll3d6();
        document.getElementById("dex-Val").innerHTML = roll3d6();
        document.getElementById("con-Val").innerHTML = roll3d6();
        document.getElementById("itel-Val").innerHTML = roll3d6();
        document.getElementById("wisdom-Val").innerHTML = roll3d6();
        document.getElementById("charisma-Val").innerHTML = roll3d6();
    }
}

