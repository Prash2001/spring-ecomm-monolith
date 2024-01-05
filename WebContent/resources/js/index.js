/**
 * 
 */

 function search(path) {
        // Get the input value from the search box
        var searchString = document.querySelector('.search-box').value;

        // Create a dynamic URL using the search string
        var url = path+'/product/searchProducts?searchString=' + encodeURIComponent(searchString);

        // Navigate to the URL
        window.location.href = url;
    }
    
    function goToWishList(path){
		// Create a dynamic URL using the search string
        var url = path+'/user/addWishListItem';

        // Navigate to the URL
        window.location.href = url;
	}
	
	function changeSection(section, path){
		if(section !='All'){
			if(section =='Women'){
				document.getElementById("mainImg").style.backgroundImage = "url("+path+"/resources/img/women.png)";
				document.getElementsByClassName("sub-heading")[0].innerHTML = "You go girl...";
			}
			if(section =='Men'){
				document.getElementById("mainImg").style.backgroundImage = "url("+path+"/resources/img/men.png)";
				document.getElementsByClassName("sub-heading")[0].innerHTML = "Customer's Most Loved...";
			}
			if(section =='Kids'){
				document.getElementById("mainImg").style.backgroundImage = "url("+path+"/resources/img/kids.png)";
				document.getElementsByClassName("sub-heading")[0].innerHTML = "Best Travel Clothes...";
			}
			if(section =='Accessories'){
				document.getElementById("mainImg").style.backgroundImage = "url("+path+"/resources/img/accessories.png)";
				document.getElementsByClassName("sub-heading")[0].innerHTML = "Best Fashion Accessories...";
			}
		}
	}
	function setSection(path, section){
		var url = path+'/product/setSession?section='+section;
console.log(section);
        // Navigate to the URL
        window.location.href = url;
	}
	
	 