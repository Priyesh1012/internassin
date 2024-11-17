let infos = fetch("http://localhost:8080/api/home")
    .then(async (value1) => {


        var items = await value1.json();

        var mybox = document.getElementsByClassName(`mybox`)[0];
        for (var i = 0; i < items.length; i++) {
            var data = document.createElement(`div`);
            data.classList.add("box");
            mybox.appendChild(data);
            console.log(`box${i}`);
            var h5 = document.createElement("h5");
            h5.innerHTML = items[i].employId;
            data.appendChild(h5);
            var name = document.createElement("h5");
            name.innerHTML = items[i].name;
            data.appendChild(name);
            var age = document.createElement("h5");
            age.innerHTML = items[i].age;
            data.appendChild(age);
            var country = document.createElement("h5");
            country.innerHTML = items[i].country;
            data.appendChild(country);


            var updatebtn = document.createElement("button");
            updatebtn.innerHTML = "Update";
            updatebtn.classList.add("updatebutton");
            updatebtn.onclick = function(){
                location.href = "update.html";
            };
            updatebtn.id = items[i].employId;
            data.appendChild(updatebtn);
            



            var delbtn = document.createElement("button");
            delbtn.innerText = "Delete";
            delbtn.classList.add("delbutton");
            delbtn.id = items[i].employId;
            data.appendChild(delbtn);
            delbtn.addEventListener("click", del);

        }


        function del(event) {
            console.log(event);
            var empid = event.target.id;
            console.log(empid);
            fetch(`http://localhost:8080/api/delinfo/${empid}`, {
                method: "DELETE"
            }
            )
        }

    }
    )
