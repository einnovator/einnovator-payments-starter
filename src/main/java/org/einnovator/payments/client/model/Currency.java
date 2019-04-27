package org.einnovator.payments.client.model;

public enum Currency {

	//General currency	¤	&curren;	&#164;	&#xA4;

	EUR("Euro", "&euro;", "&#8364;", "EUR"),
	
	USD("Dollar", "$", null, "USD", "USA"),
	
	GBP("Pound", "&pound;", null, "GBP", "UK"),
	
	JPY("Yen", "&yen;", null, "JPY", true, "Japan"),
	
	//FRANC("Franc", "&#8355;", "France"),
	//LIRA("Lira", "&#8356;", "Italy"),	
	//PESETA("Peseta", "&#8359;", "Spain"),		
	//DRACHMA("Drachma", "&#8367;", "Greece"),	

	BRL("Real", "&#8355;", null, "BRL", "Brasil"),	
	
	//Colon (Costa Rica, El Salvador)	—	&#8353;	&#x20A1;
	//Naira (Nigeria)—	&#8358;	&#x20A6;
	//Rupee (India)	—	&#8360;	&#x20A8;
	//Won (Korea)	—	&#8361;	&#x20A9;
	//New sheqel (Israel)	—	&#8362;	&#x20AA;
	//Dong (Vietnam)—	&#8363;	&#x20AB;
	//Kip (Laos)	—	&#8365;	&#x20AD;
	//Tugrik (Mongolia)	—	&#8366;	&#x20AE;
	;
	
//	AED("Dirham", "&#8355;", null, "BRL", "United Arab Emirates"),	  
//	AFN	Afghanistan Afghani
//	ALL	Albania Lek
//	AMD	Armenia Dram
//	ANG	Netherlands Antilles Guilder
//	AOA	Angola Kwanza
//	ARS	Argentina Peso
//	AUD	Australia Dollar
//	AWG	Aruba Guilder
//	AZN	Azerbaijan Manat
//	BAM	Bosnia and Herzegovina Convertible Marka
//	BBD	Barbados Dollar
//	BDT	Bangladesh Taka
//	BGN	Bulgaria Lev
//	BHD	Bahrain Dinar
//	BIF	Burundi Franc
//	BMD	Bermuda Dollar
//	BND	Brunei Darussalam Dollar
//	BOB	Bolivia Bolíviano
//	BRL	Brazil Real
//	BSD	Bahamas Dollar
//	BTN	Bhutan Ngultrum
//	BWP	Botswana Pula
//	BYN	Belarus Ruble
//	BZD	Belize Dollar
//	CAD	Canada Dollar
//	CDF	Congo/Kinshasa Franc
//	CHF	Switzerland Franc
//	CLP	Chile Peso
//	CNY	China Yuan Renminbi
//	COP	Colombia Peso
//	CRC	Costa Rica Colon
//	CUC	Cuba Convertible Peso
//	CUP	Cuba Peso
//	CVE	Cape Verde Escudo
//	CZK	Czech Republic Koruna
//	DJF	Djibouti Franc
//	DKK	Denmark Krone
//	DOP	Dominican Republic Peso
//	DZD	Algeria Dinar
//	EGP	Egypt Pound
//	ERN	Eritrea Nakfa
//	ETB	Ethiopia Birr
//	EUR	Euro Member Countries
//	FJD	Fiji Dollar
//	FKP	Falkland Islands (Malvinas) Pound
//	GBP	United Kingdom Pound
//	GEL	Georgia Lari
//	GGP	Guernsey Pound
//	GHS	Ghana Cedi
//	GIP	Gibraltar Pound
//	GMD	Gambia Dalasi
//	GNF	Guinea Franc
//	GTQ	Guatemala Quetzal
//	GYD	Guyana Dollar
//	HKD	Hong Kong Dollar
//	HNL	Honduras Lempira
//	HRK	Croatia Kuna
//	HTG	Haiti Gourde
//	HUF	Hungary Forint
//	IDR	Indonesia Rupiah
//	ILS	Israel Shekel
//	IMP	Isle of Man Pound
//	INR	India Rupee
//	IQD	Iraq Dinar
//	IRR	Iran Rial
//	ISK	Iceland Krona
//	JEP	Jersey Pound
//	JMD	Jamaica Dollar
//	JOD	Jordan Dinar
//	JPY	Japan Yen
//	KES	Kenya Shilling
//	KGS	Kyrgyzstan Som
//	KHR	Cambodia Riel
//	KMF	Comorian Franc
//	KPW	Korea (North) Won
//	KRW	Korea (South) Won
//	KWD	Kuwait Dinar
//	KYD	Cayman Islands Dollar
//	KZT	Kazakhstan Tenge
//	LAK	Laos Kip
//	LBP	Lebanon Pound
//	LKR	Sri Lanka Rupee
//	LRD	Liberia Dollar
//	LSL	Lesotho Loti
//	LYD	Libya Dinar
//	MAD	Morocco Dirham
//	MDL	Moldova Leu
//	MGA	Madagascar Ariary
//	MKD	Macedonia Denar
//	MMK	Myanmar (Burma) Kyat
//	MNT	Mongolia Tughrik
//	MOP	Macau Pataca
//	MRO	Mauritania Ouguiya
//	MUR	Mauritius Rupee
//	MVR	Maldives (Maldive Islands) Rufiyaa
//	MWK	Malawi Kwacha
//	MXN	Mexico Peso
//	MYR	Malaysia Ringgit
//	MZN	Mozambique Metical
//	NAD	Namibia Dollar
//	NGN	Nigeria Naira
//	NIO	Nicaragua Cordoba
//	NOK	Norway Krone
//	NPR	Nepal Rupee
//	NZD	New Zealand Dollar
//	OMR	Oman Rial
//	PAB	Panama Balboa
//	PEN	Peru Sol
//	PGK	Papua New Guinea Kina
//	PHP	Philippines Peso
//	PKR	Pakistan Rupee
//	PLN	Poland Zloty
//	PYG	Paraguay Guarani
//	QAR	Qatar Riyal
//	RON	Romania Leu
//	RSD	Serbia Dinar
//	RUB	Russia Ruble
//	RWF	Rwanda Franc
//	SAR	Saudi Arabia Riyal
//	SBD	Solomon Islands Dollar
//	SCR	Seychelles Rupee
//	SDG	Sudan Pound
//	SEK	Sweden Krona
//	SGD	Singapore Dollar
//	SHP	Saint Helena Pound
//	SLL	Sierra Leone Leone
//	SOS	Somalia Shilling
//	SPL*	Seborga Luigino
//	SRD	Suriname Dollar
//	STD	São Tomé and Príncipe Dobra
//	SVC	El Salvador Colon
//	SYP	Syria Pound
//	SZL	Swaziland Lilangeni
//	THB	Thailand Baht
//	TJS	Tajikistan Somoni
//	TMT	Turkmenistan Manat
//	TND	Tunisia Dinar
//	TOP	Tonga Pa'anga
//	TRY	Turkey Lira
//	TTD	Trinidad and Tobago Dollar
//	TVD	Tuvalu Dollar
//	TWD	Taiwan New Dollar
//	TZS	Tanzania Shilling
//	UAH	Ukraine Hryvnia
//	UGX	Uganda Shilling
//	USD	United States Dollar
//	UYU	Uruguay Peso
//	UZS	Uzbekistan Som
//	VEF	Venezuela Bolívar
//	VND	Viet Nam Dong
//	VUV	Vanuatu Vatu
//	WST	Samoa Tala
//	XAF	Communauté Financière Africaine (BEAC) CFA Franc BEAC
//	XCD	East Caribbean Dollar
//	XDR	International Monetary Fund (IMF) Special Drawing Rights
//	XOF	Communauté Financière Africaine (BCEAO) Franc
//	XPF	Comptoirs Français du Pacifique (CFP) Franc
//	YER	Yemen Rial
//	ZAR	South Africa Rand
//	ZMW	Zambia Kwacha
//	ZWD	Zimbabwe Dollar
	
	
	private String name;
	
	private String html;
	
	private String hex;
	
	private String code;
	
	private String country;
	
	private String countryKey;

	private boolean zeroDecimal;
	
	/**
	 * Create instance of {@code Currency}.
	 *
	 * @param name
	 */
	private Currency(String name) {
		this(name, null);
	}

	/**
	 * Create instance of {@code Currency}.
	 *
	 * @param name
	 * @param html
	 */
	private Currency(String name, String html) {
		this(name, html, html);
	}


	/**
	 * Create instance of {@code Currency}.
	 *
	 * @param name
	 * @param html
	 */
	private Currency(String name, String html, String hex) {
		this(name, html, hex, null);
	}

	/**
	 * Create instance of {@code Currency}.
	 *
	 * @param name
	 * @param html
	 * @param hex
	 * @param code
	 */
	private Currency(String name, String html, String hex, String code) {
		this(name, html, hex, code, null);
	}

	/**
	 * Create instance of {@code Currency}.
	 *
	 * @param name
	 * @param html
	 * @param hex
	 * @param code
	 * @param country
	 */
	private Currency(String name, String html, String hex, String code, String country) {
		this(name, html, hex, code, country, (country!=null ? "country." + country : null));
	}

	/**
	 * Create instance of {@code Currency}.
	 *
	 * @param name
	 * @param html
	 * @param hex
	 * @param code
	 * @param country
	 * @param countryKey
	 */
	private Currency(String name, String html, String hex, String code, String country, String countryKey) {
		this(name, html, hex, code, false, country, countryKey);
	}

	private Currency(String name, String html, String hex, String code, boolean zeroDecimal, String country) {
		this(name, html, hex, code, zeroDecimal, country, null);
	}
	
	private Currency(String name, String html, String hex, String code, boolean zeroDecimal, String country, String countryKey) {
		this.name= name;
		this.html = html;
		this.hex = hex!=null ? hex: html;
		this.code = code!=null ? code : name;
		this.country = country;
		this.countryKey = countryKey!=null ? countryKey : (country!=null ? "country." + country : null);
		this.zeroDecimal = zeroDecimal;
	}

	private Currency() {
	}

	//
	// Getters an Setters
	//
	
	/**
	 * Get the value of property {@code name}.
	 *
	 * @return the {@code name}
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get the value of property {@code html}.
	 *
	 * @return the {@code html}
	 */
	public String getHtml() {
		return html;
	}
	
	/**
	 * Get the value of property {@code hex}.
	 *
	 * @return the {@code hex}
	 */
	public String getHex() {
		return hex;
	}

	/**
	 * Get the value of property {@code html}.
	 *
	 * @return the {@code html}
	 */
	public String getSymbol() {
		return getHtml();
	}

	/**
	 * Get the value of property {@code code}.
	 *
	 * @return the {@code code}
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Get the value of property {@code country}.
	 *
	 * @return the {@code country}
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Get the value of property {@code countryKey}.
	 *
	 * @return the {@code countryKey}
	 */
	public String getCountryKey() {
		return countryKey;
	}
	
	/**
	 * Get the value of property {@code zeroDecimal}.
	 *
	 * @return the {@code zeroDecimal}
	 */
	public boolean isZeroDecimal() {
		return zeroDecimal;
	}

	
}

