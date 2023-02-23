 $(document).ready(function(){
	
	 document.getElementById('btnOrd').addEventListener('click', ()=>{

        // 배송정보 관련 변수
        const recipName = document.querySelector('input[name=orderer]').value;
        const recipHp = document.querySelector('input[name=hp]').value;
        const recipZip = document.querySelector('input[name=zip]').value;
        const recipAddr1 = document.querySelector('input[name=addr1]').value;
        const recipAddr2 = document.querySelector('input[name=addr2]').value;


        let isOk = confirm('주문하시겠습니까?');

        if(!isOk){
            return false;
        }

        let prodNos = document.querySelectorAll("input[name=prodNo]"); 
		let prodNoArr = [];
		for(let i =0; i < prodNos.length; i++){
			prodNoArr.push(prodNos[i].value);
		}
			
		
		let ordPayment = $('input[name=ordPayment]:checked').val();
		if(ordPayment == null){
				alert('결제수단을 선택해주세요.');
				return false;
			}
			
		let ordUid = $('input[name=uid]').val();
		let ordCount = parseInt($('.ordCount').text());
		let ordPrice = parseInt($('.ordPrice').text().replaceAll(',',''));
		let ordDiscount = parseInt($('.ordDiscount').text().replaceAll(',',''));
		let ordDelivery = parseInt($('.ordDelivery').text().replaceAll(',',''));
		let savePoint = $('.savePoint').text().replaceAll(',','');
		let usedPoint = parseInt($('.pointDC').text().replaceAll(',',''));
		let ordTotPrice = parseInt($('.finTot').text().replaceAll(',',''));

        let orderList = {
            "ordUid" : ordUid,
            "ordCount" : ordCount,
            "ordPrice" : ordPrice,
            "ordDiscount" : ordDiscount,
            "ordDelivery" : ordDelivery,
            "ordTotPrice" : ordTotPrice,
            "savePoint" : savePoint,
            "usedPoint" : usedPoint,
            "recipName" : recipName,
            "recipHp" : recipHp,
            "recipZip" : recipZip,
            "recipAddr1" : recipAddr1,
            "recipAddr2" : recipAddr2,
            "ordPayment" : ordPayment,
            "ordComplete" : 1,
        }


        // AJAX 전송
        const xhr = new XMLHttpRequest();
        xhr.open('post','/Kmarket2/product/order');
        xhr.responseType = "json";
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send(JSON.stringify({"orderList" : orderList}));

        xhr.onreadystatechange = function(){

            if(xhr.readyState == XMLHttpRequest.DONE){
                if(xhr.status == 200){
                    const data = xhr.response;
                    console.log(data);

                    if(data > 0){
                        location.href = "/Kmarket2/product/complete";
                    }

                }else{
                    alert('요청을 실패하였습니다.\n 잠시 후 다시 시도해 주세요.');
                }
            }
        };
    });

	
	
	
	
	
	
});