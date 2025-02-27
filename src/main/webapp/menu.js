/**
 * 
 */

const resId= document.querySelectorAll(".resturant-id");

const btn = document.querySelector(".add-to-cart");

btn.addEventListener("click",(e)=>{
	e.preventDefault();

	resId.forEach((id)=>{
		console.log(id.innerHTML);
	})	
})
