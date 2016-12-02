package de.menodata.timedemoapp;

import android.content.Context;
import android.util.Log;

import net.time4j.android.ApplicationStarter;
import net.time4j.format.expert.ChronoFormatter;
import net.time4j.format.expert.PatternType;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.Locale;

@RunWith(PowerMockRunner.class)
@PrepareForTest({Log.class})
public class InitTest
{
	@Mock
	Context mContext;

	@Test
	public void testWithPrepareAssets()
	{
		PowerMockito.mockStatic(Log.class);

		mContext = Mockito.mock(Context.class);

		ApplicationStarter.prepareAssets(mContext);

		PatternType patternType = PatternType.CLDR;
		Locale locale = Locale.getDefault();

		ChronoFormatter.ofDatePattern("yyyyMMdd", patternType, locale);
	}

	@Test
	public void testWithInitializeTrue()
	{
		PowerMockito.mockStatic(Log.class);

		mContext = Mockito.mock(Context.class);

		ApplicationStarter.initialize(mContext, true);

		PatternType patternType = PatternType.CLDR;
		Locale locale = Locale.getDefault();

		ChronoFormatter.ofDatePattern("yyyyMMdd", patternType, locale);
	}

	@Test
	public void testWithInitializeFalse()
	{
		PowerMockito.mockStatic(Log.class);

		mContext = Mockito.mock(Context.class);

		ApplicationStarter.initialize(mContext, false);

		PatternType patternType = PatternType.CLDR;
		Locale locale = Locale.getDefault();

		ChronoFormatter.ofDatePattern("yyyyMMdd", patternType, locale);
	}
}
