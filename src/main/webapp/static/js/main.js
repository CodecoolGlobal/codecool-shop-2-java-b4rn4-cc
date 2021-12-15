// const categorySelect = document.getElementById("sort-category");
// const supplierSelect = document.getElementById("sort-supplier");
//
// categorySelect.addEventListener("change", handleSelection);
//
// function handleSelection(e) {
//     const value = e.target.value;
//     console.log(value);
// }

function addButton() {
    const addButtonList = document.getElementsByClassName("add-button");
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