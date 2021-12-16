const addButtonList = document.getElementsByClassName("add-button");

function addButton() {
    for (const addButton of addButtonList){
        addButton.addEventListener("click", () => {
            const id = addButton.id;
            postData(`/cart?id=${id}`);
        });
    }

    async function postData(url = '') {
        await fetch(url, {
            method: 'POST'
        });
    }
}

function deleteButton(){
    const deleteButtonList = document.getElementsByClassName("delete-button");
    for (const deleteButton of deleteButtonList){
        deleteButton.addEventListener("click", () => {
            const id = deleteButton.id;
            deleteData(`/cart?id=${id}`).then(r => location.reload());
        })
    }

    async function deleteData(url = '') {
        await fetch(url, {
            method: 'DELETE'
        });
    }
}

addButton();
deleteButton();
setupEventListenersForPopup();

function setupEventListenersForPopup() {
    for (const addButtonListElement of addButtonList) {
        addButtonListElement.addEventListener("click", showPopup);
    }
}

function showPopup(e) {
    let button = e.target;
    let id = button.id;
    let popupToShow = document.getElementById("popup"+id);
    popupToShow.classList.toggle("show");
    setTimeout((event) => hidePopup(popupToShow), 2200);
}

function hidePopup(popup) {
    popup.classList.toggle("show");
}