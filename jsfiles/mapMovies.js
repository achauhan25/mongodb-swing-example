function () {	
	for(var i=0; i<this.langGenreTags.length;i++)	
	{
		if(this.lastCollctn.week==curWeek && this.lastCollctn.year==curYear)
		{
			collThisWeek = this.lastCollctn.amountCollected;
		}
		else
		{
			collThisWeek = 0;
		}
		 
		val = 	{
					topData: [{
								movieId : this._id,
								movieName : this.movieName,
								score : collThisWeek+(5*this.totalCollctn)+(100*(this.fbMentions + this.twtMentions))
							}]
				};
		emit(this.langGenreTags[i], val);	
	}
}