package com.example.periodictableapplication.data.api.model

import com.google.gson.annotations.SerializedName

data class Element(
    @SerializedName("appearance")
    val appearance: String?,
    @SerializedName("atomic_mass")
    val atomicMass: Double,
    @SerializedName("block")
    val block: String,
    @SerializedName("bohr_model_3d")
    val bohrModel3d: String?,
    @SerializedName("bohr_model_image")
    val bohrModelImage: String?,
    @SerializedName("boil")
    val boil: Double?,
    @SerializedName("category")
    val category: String,
    @SerializedName("cpk-hex")
    val cpkHex: String?,
    @SerializedName("density")
    val density: Double,
    @SerializedName("discovered_by")
    val discoveredBy: String?,
    @SerializedName("electron_affinity")
    val electronAffinity: Double,
    @SerializedName("electron_configuration")
    val electronConfiguration: String,
    @SerializedName("electron_configuration_semantic")
    val electronConfigurationSemantic: String,
    @SerializedName("electronegativity_pauling")
    val electronegativityPauling: Double?,
    @SerializedName("group")
    val group: Int,
    @SerializedName("image")
    val image: Image,
    @SerializedName("ionization_energies")
    val ionizationEnergies: List<Double>,
    @SerializedName("melt")
    val melt: Double?,
    @SerializedName("molar_heat")
    val molarHeat: Double?,
    @SerializedName("name")
    val name: String,
    @SerializedName("named_by")
    val namedBy: String?,
    @SerializedName("number")
    val number: Int,
    @SerializedName("period")
    val period: Int,
    @SerializedName("phase")
    val phase: String,
    @SerializedName("shells")
    val shells: List<Int>,
    @SerializedName("source")
    val source: String,
    @SerializedName("spectral_img")
    val spectralImg: String?,
    @SerializedName("summary")
    val summary: String,
    @SerializedName("symbol")
    val symbol: String,
    @SerializedName("wxpos")
    val wxpos: Int,
    @SerializedName("wypos")
    val wypos: Int,
    @SerializedName("xpos")
    val xpos: Int,
    @SerializedName("ypos")
    val ypos: Int,
    @SerializedName("eng_name")
    val engName: String,
    @SerializedName("latin_name")
    val latinName: String
)
