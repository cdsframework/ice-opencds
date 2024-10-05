package org.cdsframework.ice.service;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.cdsframework.ice.util.TimePeriod;

public interface TargetSeriesInterface {

	public boolean containsRuleProcessed(String ruleName);

	public boolean containsTargetDose(TargetDose td);

	public SeriesRules getSeriesRules();

	public int determineDoseNumberInSeries();

	public int determineEffectiveNumberOfDosesInSeriesByDate(Date asOfDate, boolean includeShotsOnDate);

	public int determineNumberOfDosesAdministeredInSeries();

	public int determineNumberOfDosesAdministeredInSeriesByDate(Date asOfDate, boolean includeShotsOnDate);

	public String getSeriesName();

	public String getVaccineGroup();

	public Date getAdministrationDateOfTargetDoseByShotNumberNumber(int shotNumber);

	public TimePeriod getAbsoluteMinimunIntervalForTargetDose(int doseNumber);

	public String getAbsoluteMinimumIntervalForTargetDoseInStringFormat(int doseNumber);

	public TimePeriod getAbsoluteMinimumAgeForTargetDose(int doseNumber);

	public String getAbsoluteMinimumAgeForTargetDoseInStringFormat(int doseNumber);

	public List<Vaccine> getAllPermittedVaccinesForTargetDose(int doseNumber);

	public List<Vaccine> getAllowableVaccinesForTargetDose(int doseNumber);

	public List<Vaccine> getPreferableVaccinesForTargetDose(int doseNumber);

	public Collection<String> getDiseasesSupportedByThisSeries();

	public int getDoseAfterWhichSeriesWasMarkedComplete();

	public int getDoseNumberToRecommend();

	public int getNumberOfDosesInSeries();

	public int getNumberOfShotsAdministeredInSeriesExcludingDuplicateShotsOnTheSameDay();

	public int getNumberOfShotsAdministeredInSeries();

	public TargetDose getTargetDoseByAdministeredShotNumber(int doseNumber);

	public boolean isAllowableVaccineForDoseRule(Vaccine v, int doseNumber);

	public boolean isPostForecastCheckCompleted();

	public boolean isSeriesComplete();

	public Date getSeasonStartDate();

	public Date getSeasonEndDate();

	public Date getOffSeasonStartDate();

	public Date getOffSeasonEndDate();

	public boolean targetSeasonesExists();

	public boolean getPerformPostForecastCheck();

	public TimePeriod getRecommendedAgeForTargetDose(int doseNumber);

	public TimePeriod getRecommendedIntervalForTargetDose(int doseNumber);

	public Date getFinalEarliestDate();

	public Date getFinalRecommendationDate();

	public Date getFinalOverdueDate();

	public List<Recommendation> getFinalRecommendations();

	public RecommendationStatus getRecommendationStatus();

	public Vaccine getRecommendationVaccine();

}
