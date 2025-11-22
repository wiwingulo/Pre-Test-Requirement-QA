@CekTarif
Feature: Cek Tarif Lion Parcel

  @Positive
  Scenario Outline: Checking rates in Lion Parcel app
    Given User open Lion Parcel app <pathLionParcel>
    When User click 'Cek Tarif' menu
    And User fill Asal <Asal> and Tujuan <Tujuan>
    And User click 'Cek Tarif' button
    Then User verify total rate <TotalRate>

    Examples: 
      | pathLionParcel                   | Asal   | Tujuan      | TotalRate |
      | com.lionparcel.services.consumer | Cakung | Medan Timur | Rp32.250  |

  @Negative
  Scenario Outline: Input the address less than 3 characters
    Given User open Lion Parcel app <pathLionParcel>
    When User click back button
    When User click 'Cek Tarif' menu
    And User fill Asal <Asal> and Tujuan <Tujuan>
    Then User verify error message <expectedErrorMessage>

    Examples: 
      | pathLionParcel                   | Asal   | Tujuan | expectedErrorMessage |
      | com.lionparcel.services.consumer | Cakung | aa     | Minimal 3 karakter   |
