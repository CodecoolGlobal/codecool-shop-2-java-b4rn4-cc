const main = {
    init() {
    }
}

function addButton() {
    const addButtonList = document.getElementsByClassName("add-button");
    for (const addButton of addButtonList) {
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

function deleteButton() {
    const deleteButtonList = document.getElementsByClassName("delete-button");
    for (const deleteButton of deleteButtonList) {
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

function activeCategory() {
    const categories = document.getElementsByClassName("category");
    const url = document.URL.slice(20, 24);
    for (let category of categories) {
        if (category.id.slice(0, 4) !== url && category.classList.contains("active")){
            category.classList.remove("active")
        }
        if (category.id.slice(0, 4) === url) {
            category.classList.add("active")
        }
    }

}

addButton();
deleteButton();
activeCategory();