/**
 * 
 */
function increaseQuantity(path,productId,cartId){
	var url = path+'/cartItem/increaseQuantity?productId=' + encodeURIComponent(productId)+'&cartId='+encodeURIComponent(cartId);
	window.location.href = url;
}
function decreaseQuantity(path,productId,cartId){
	var url = path+'/cartItem/decreaseQuantity?productId=' + encodeURIComponent(productId)+'&cartId='+encodeURIComponent(cartId);
	window.location.href = url;
}

function removeCartItem(path,productId,cartId){
	var url = path+'/cartItem/removeCartItem?productId=' + encodeURIComponent(productId)+'&cartId='+encodeURIComponent(cartId);
	window.location.href = url;
}