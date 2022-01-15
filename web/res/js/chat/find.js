var trElem = document.querySelectorAll('#clickTr');
if(trElem) {
    trElem.forEach((item) => {
        item.addEventListener('click', ()=>{
            var iroom = item.dataset.iroom;
            location.href = `/chat?room=${iroom}`;
        });
    });
}