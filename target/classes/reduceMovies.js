function(key, values) {
	topArr = [];
	for (var idx = 0; idx < values.length; idx++) 
	{
		val = 	{
					movieId : values[idx].topData[0].movieId,
					movieName : values[idx].topData[0].movieName,
					score : values[idx].topData[0].score,
				
				};
		topArr[idx] = val;
	}
	topArr.sort(function(a,b)	
			{ 
				return -1*(parseFloat(a.score) - parseFloat(b.score));
			} );
	topArr = topArr.slice(0, 5);
	return {topData:topArr};
}