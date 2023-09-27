
// 리뷰 작성하기
let newReview = document.querySelector(".new-review");
  let newReviewModal = document.querySelector("#new-review-modal");
  newReview.addEventListener("click", () => {
    console.log("new!");
    newReviewModal.style.display = "block";
  });
  let newReviewClose = document.querySelector("#new-review-modal .btn-secondary");
  newReviewClose.addEventListener("click", () => {
    console.log("close!");
    newReviewModal.style.display = "none";
  });
  let newReviewSave = document.querySelector("#new-review-modal .btn-primary");
  newReviewSave.addEventListener("click", () => {
    console.log("save!");
    newReviewModal.style.display = "none";
  });

// 리뷰 수정하기
let updateReview = document.querySelector(".update-review");
let updateReviewModal = document.querySelector("#update-review-modal");
updateReview.addEventListener("click", ()=>{
    console.log("update!");
    updateReviewModal.setAttribute("style", "display:block;");
});
let updateReviewClose = document.querySelector("#update-review-modal .btn-secondary");
updateReviewClose.addEventListener("click", ()=>{
    console.log("close!");
    updateReviewModal.style.display = "none";
});
let updateReviewSave = document.querySelector("#update-review-modal .btn-primary");
updateReviewSave.addEventListener("click", ()=>{
    console.log("save!");
    updateReviewModal.style.display = "none";
});